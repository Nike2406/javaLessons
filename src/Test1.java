import java.util.Random;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        /*
         * Future - �������, ��� � ���������� ������ ������ �������� ��������
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
                throw new Exception("Something bad happened"); // * �������� ���������� �� ������ ����
            }
            return randomValue;
        });
        executorService1.shutdown();

        try {
            int result = future.get(); // get() - ���������� ���������� ������ ������
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) { // * ����� ����������
            Throwable ex = e.getCause(); // �������� ����� ����������
            System.out.println(ex.getMessage());
        }
    }
}
