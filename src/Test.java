public class Test {
    public static void main(String[] args) {
       Dog dog = new Dog();
       // Upcasting - восходящее преобразование,
        // т.е. объект класса Dog стал ок animal
        Animal animal = dog;

        // Downcasting - нисходящее преобразование
        Dog dog2 = (Dog)animal;
        dog2.bark();

        Animal a = new Animal();
        Dog dog3 = (Dog)a;
        dog3.bark();
    }

    public static void test(Animal animal) {
        animal.eat();
    }
}
