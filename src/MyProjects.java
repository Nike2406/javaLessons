import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyProjects {
    public static void main(String [] args) throws InterruptedException {
        /*
        * CountDownLatch - "защелка обратного отсчета", потокобезопасный метод
        * (под капотом уже есть synchronised), отсчитывающий количество входов
        * */
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // Создает три потока через thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            // выдаем трем потокам задание
            executorService.submit(new Processor(i, countDownLatch));
        }

        // shutdown() - прекращает выдачу заданий
        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown(); // декрементирует переменную на 1
        }
    }
}

class Processor implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // ожидаем когда countDownLatch будет равным 0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread with id " + id + " proceed.");

    }
}
