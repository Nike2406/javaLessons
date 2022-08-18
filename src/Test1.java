import java.util.Random;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        /*
         * Future - ожидаем, что в результате работы потока вернется значение
         * */
        Future<Integer> future = executorService1.submit(() -> { // Callable
            System.out.println("Starting");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finishing");

            Random random = new Random();
            int randomValue = random.nextInt(10);

            if (randomValue < 5) {
                throw new Exception("Something bad happened"); // * Передаем исключение во второй блок
            }
            return randomValue;
        });
        executorService1.shutdown();

        try {
            int result = future.get(); // get() - Дожидается завершения работы потока
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) { // * Ловим исключение
            Throwable ex = e.getCause(); // Получаем текст исключения
            System.out.println(ex.getMessage());
        }
    }
}
