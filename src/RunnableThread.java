public class RunnableThread {
    public static void main(String[] args) {
        // Runnable - ����� ������ ������ �������� ������,
        // �.�. ��������� �������������� ������ ����� run

        Thread myThread = new Thread(new Runner());
        myThread.start();

        /*
        * ��������� ������������� �����, ����� ����������� ������
        * ��� ������
        * */
    }

    static class Runner implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hellow from MyThread " + i);
            }
        }
    }
}

/*
* Thread - ��� ���������� ��� ���������� �������.
  Runnable - ��� ���������� ��� ����������� �������.

  ���� ������������� Runnable ������� � ���, ��� ��� ���������
  ��������� �������� ���������� ������ �� ������ ���������� ��������.*
*
    1. ��������������� � JAVA ������ �� ���������� ������� Thread
    2. � ��������� ����������� ������ ����� ���� �������� ����������� �����-�� ������ �����,
    �� ������������� ������������ � JAVA �� ��������������, �����: implements Runnable
    3. ��������� Runnable ����� �������������� ��������� � ������� - ��� ������� �����������
    ��� ������������ �������, ������� ����� ���� ��������� ���-�� � ������ �����
    (�����, �������, �����, ����� � �.�.)
*/