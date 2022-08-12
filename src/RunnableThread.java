public class RunnableThread {
    public static void main(String[] args) {
        // Runnable - более чистый способ создани€ потока,
        // т.к. позвол€ет переопределить только метод run

        Thread myThread = new Thread(new Runner());
        myThread.start();

        /*
        * ѕрограмма заканчиваетс€ тогда, когда заканчивают работу
        * все потоки
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
* Thread - это абстракци€ над физическим потоком.
  Runnable - это абстракци€ над выполн€емой задачей.

  ѕлюс использовани€ Runnable состоит в том, что это позвол€ет
  логически отделить выполнение задачи от логики управлени€ потоками.*
*
    1. ћногопоточность в JAVA отнюдь не ограничена классом Thread
    2. ¬ контексте определЄнной задачи может быть выгоднее наследовать какой-то другой класс,
    но множественное наследование в JAVA не поддерживаетс€, выход: implements Runnable
    3. »нтерфейс Runnable имеет посредственное отношение к потокам - его следует расценивать
    как передаваемую функцию, котора€ может быть выполнена где-то в другом месте
    (поток, очередь, класс, метод и т.п.)
*/