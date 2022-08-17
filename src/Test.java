import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    /*
     * Паттерн producer consumer (производитель/потребитель) -
     * один или более потоков дают информацию, а другие забирают
     * */

    // BlockingQueue - создает очередь, настроенную на работу с потоками (FIFO)
    // на 10 элементов
                            // интерфейс                        // реализация
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String [] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100)); // put - помещает элемент в очередь и ожидает
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take()); // take - забирает элемент из очереди
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}
