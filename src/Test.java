import java.util.Random;

public class Test {
    public static void main(String [] args) throws InterruptedException {
        /*
        * ��� ���������� ������ ������ ����� ������������ ������
        * c ������� Thread.interrupt()
        * */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) { // ����������, ����� �� ������������
                        System.out.println("Thread is interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });

        System.out.println("Thread starts");
        thread.start();

        Thread.sleep(1000);
        thread.interrupt(); // ���� ������ ������, ��� �� ����� ����������
        /*
        * thread.stop() - ��� �� ������������, �.�. ��������� ��� ��������
        * */
        thread.join();
        System.out.println("Thread finished");
    }
}
