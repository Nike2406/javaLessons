// Абстрактные классы очень похожи на интерефейсы

// Интерфейс - контракт,то, что класс умеет делать
// Абстрактный класс - то, чем класс является
// Например, кошка и собака являются животными

public class MyProjects {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        cat.eat();
        cat.makeSound();
        dog.eat();
        dog.makeSound();
    }
}


