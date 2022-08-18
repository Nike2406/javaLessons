import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    private static final Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() { // Singleton

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        /*
         * Заходим в метод, отсчитываем 10, 11й - остановится
         * */
        semaphore.acquire();
        try {
            doWork();
        } finally {
            /*
             * После выполнения действий освобождаем поток
             * release - должен всегда выполняться в finally-блоке
             * */
            semaphore.release();
        }
    }

    public void doWork() {
        synchronized (this) {
            connectionsCount++;
            System.out.println("ConnectoinsCount: " + connectionsCount);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            connectionsCount--;
        }
    }
}
