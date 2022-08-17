public class Test1 {

    private int counter;

    public static void main(String[] args) throws InterruptedException {
        /*
         * volatile  используется, когда один поток пишет в переменную,
         * а остальные потоки читают из него. Обеспечивает, что переменная не кэшируется в памяти ядра,
         * а читается из общей памяти.
         *
         * synchronised - два или более потоков пишут в одну переменную
         * */

        Test1 test1 = new Test1();
        /*
        * Каждому объекту в Java присваивается монитор, который привязывается к потоку
        * Синхронизируемся всегда на объекте (например, this)
        * */
        test1.doWork();
    }

    public synchronized void increment() { // синхронизация метода
        // Все, что находится в теле метода, может выполнятся только одним потоком
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join(); // ожидаем завершения работы потока
        thread2.join(); // проброс ошибки выше - плохая практика

        System.out.println(counter);
    }
}
