public class Test {
    public static void main(String[] args) {
        // При наследовании типа Animal для объекта класса Dog,
        // мы можешм создавать форму типа animal из объекта класса Dog()
        Animal animal = new Dog();
        animal.eat(); // - имеем доступ
        // animal.bark(); - не имеем доступа
        // Позднее связывание - реализация у потомка приоритетнее
        Dog dog = new Dog();
        dog.eat(); // - имеем доступ
        dog.bark(); // - имеем доступа
        System.out.println();

        Animal animal1 = new Animal();
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        // Использование теста для разных типов
        test(animal1);
        test(dog1);
        test(cat1);
    }

    public static void test(Animal animal) {
        animal.eat();
    }
}
