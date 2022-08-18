import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String [] args) {
        /*
        * Semaphore мсполльзуется, когда множество потоков используют один ресурс и мы хотим
        * ограничить доступ к этому ресурсу.
        * Для него нужно предать количество разрешений для потоков.
        * */
        Semaphore semaphore = new Semaphore(3); // Максимум 3 потока

        try {
            semaphore.acquire(); // Начинаем взаимодействие с ресурсом
            semaphore.acquire();
            semaphore.acquire();
            System.out.println("All permits have been acquired");
            semaphore.acquire();
            System.out.println("Can't reach here...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        semaphore.release(); // отпускает разрешение (передает другому потоку)

        System.out.println(semaphore.availablePermits()); // Показывает количество свободных разрешенных потоков
    }
}
