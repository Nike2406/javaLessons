import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String [] args) throws InterruptedException {
        /*
        * Thread pool - позволяет автоматически создавать потоки
        * ExecutorService = thread pool, сервис по выполнению,
        * принимает на вход количетво потоков
        * */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            // передаем задания для двух потоков
            executorService.submit(new Work(i));
        }
        // прекращает передачу заданий и приступает к их выполнению
        executorService.shutdown();
        System.out.println("All tasks submitted");
        /*
        * При слишком большом ожидании выполнения задания можно
        * использовать принудительное заверешние через
        * executorService.awaitTermination(количество, изеряемая_величина)
        * */
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable {
    private final int id;

    public Work(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work " + id + " was completed");
    }
}
