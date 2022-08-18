import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        /*
         * Callable & Future - ��������� ���������� �������� �� �������,
         * � ����� ����������� ���������� �� �������
         *
         * Runnable - �� ��������� ������
         * Callable - ���������� ��������
         * ��� ����� ���������� ������� ()->{}
         * */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception { // ������ run, �� ���������� �������� � ����������� ����������
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finishing");
                return new Random().nextInt(10);
            }
        });
        executorService.shutdown();
    }
}
