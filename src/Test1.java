import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner1.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner1.secondThread();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        runner1.finished();
    }
}

class Runner1 {
    private final Account1 account1 = new Account1();
    private final Account1 account2 = new Account1();
    Random random = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    /*
     * Deadlock - часто происходит, когдда синхронизация происодит в разном порядке
     *
     * Например, 1й поток взял в лок lock1, а второй поток lock2
     * и теперь 1й поток не может взять lock2, а второй lock1, так и висят.
     * */

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        /*
         * tryLock() - пытается взять лок и возвращает true при успешном заборе
         * */
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }
                if (firstLockTaken) {
                    lock1.unlock();
                }
                if (secondLockTaken) {
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1); // даем время, чтобы освободить лок
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void firstThread() {
        for (int i = 0; i < 10_000; i++) {
            takeLocks(lock1, lock2);
            try {
                Account1.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        for (int i = 0; i < 10_000; i++) {
            takeLocks(lock2, lock1);
            try {
                Account1.transfer(account2, account2, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("First account balance: " + account1.getBalance());
        System.out.println("Second account balance: " + account2.getBalance());
        System.out.println("Total accounts balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account1 {
    private int balance = 10_000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account1 acc1, Account1 acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
