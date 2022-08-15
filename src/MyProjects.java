import java.util.Scanner;

public class MyProjects {
    public static void main(String [] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }
}

class MyThread extends Thread {
     /*
     volatile - настраивает синхронизацию потоков,
        когда происходит чтение из одной переменной
        Предотвращает когеренцию кешей, когда процессорное ядро работает
        со старым кешом
    */
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
