public class BaseThread {

    /*
    * ������ �������� ������-�����������, �.�. �� ����� ���������� ����
    * ��������� ������ ������������� ����� ��������
    * */
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        // ��� ������� ������ ������������ ����� start()
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        // sleep() - ������ ����� ��������, ���������� ���������� ����������
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello from main thread!");
    }

    /*
    * ������ � java �� ����������������
    * (������ �������� �� ����� ����������, ������� ������
    * ��������������)
    * */

    static class MyThread extends Thread {
        public void run() {
            //  ����� run() - ��� ����������� �������������
            for (int i = 0; i < 10; i++) {
                System.out.println("Hellow from MyThread " + i);
            }
        }
    }
}
