package Interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Human human1 = new Human("Bob");
        animal1.sleep();
        human1.sayHello();
    }
}
