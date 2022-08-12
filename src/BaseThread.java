public class BaseThread {

    /*
    * Потоки работают псевдо-параллельно, т.е. во время выполнения кода
    * процессор быстро переключается между потоками
    * */
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        // Для запуска потока используется метод start()
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        // sleep() - данный поток засыпает, необходимо обработать исключение
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello from main thread!");
    }

    /*
    * Потоки в java не синхронизированы
    * (потоки боррятся за время процессора, поэтому выдача
    * непредсказуема)
    * */

    static class MyThread extends Thread {
        public void run() {
            //  Метод run() - для внутреннего использования
            for (int i = 0; i < 10; i++) {
                System.out.println("Hellow from MyThread " + i);
            }
        }
    }
}
