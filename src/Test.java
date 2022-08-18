import java.util.Random;

public class Test {
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

class Runner {
    private final Account1 account1 = new Account1();
    private final Account1 account12 = new Account1();
    Random random = new Random();

    public void firstThread() {
        for (int i = 0; i < 10_000; i++) {
            /*
            * Для исключения состояния гонки требуется синхронизироваться на обоих аккаунтах
            * В данном случае можно использовать влеженность, но не стоит, лучше reentrantLock
            * */
            synchronized (account1) { // Fix race condition
                synchronized (account12) {
                    Account1.transfer(account1, account12, random.nextInt(100));
                }
            }
        }
    }

    public void secondThread() {
        for (int i = 0; i < 10_000; i++) {
            synchronized (account1) {
                synchronized (account12) {
                    Account1.transfer(account12, account1, random.nextInt(100));
                }
            }
        }
    }

    public void finished() {
        System.out.println("First account balance: " + account1.getBalance());
        System.out.println("Second account balance: " + account12.getBalance());
        System.out.println("Total accounts balance: " + (account1.getBalance() + account12.getBalance()));
    }
}

class Account {
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
