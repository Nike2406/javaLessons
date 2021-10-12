package Interfaces;

/*
* Интерфейсы - способ утвердить то, что класс имеет определенный метод
* */
public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Human human1 = new Human("Bob");
//        animal1.sleep();
//        human1.sayHello();
        animal1.showInfo();
        human1.showInfo();

        Info info1 = new Animal(2);
        Info info2 = new Human("Rob");
        // Возможность сделать тип Info появляется благодаря тому,
        // что animal и human имеют у себя метод Info
        info1.showInfo();
        info2.showInfo();
        // В то же время мы не можем использовать другие объекты
        // ! info.sleep();
        outputInfo(animal1);
        outputInfo(human1);
    }

    public static void outputInfo(Info info) {
        info.showInfo();
    }
}
