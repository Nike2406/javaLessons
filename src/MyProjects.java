public class MyProjects {
    public static void main(String[] args) {
       Animal animal1 = new Animal(1);
       Animal animal2 = new Animal(1);
        /*
        * System.out.println(animal1 == animal2);
        *   // false
        *   - сравнивает ссылки на объекты (указатели)
        * equals также сравнивает объекты как ссылки
        * */
        System.out.println(animal1.equals(animal2));
    }
}

class Animal {
    private int id;

    public Animal(int id){
        this.id = id;
    }

    public boolean equals(Object obj) {
        // переопределяем метом equals для корректного сравнения
        Animal otherAnimal = (Animal) obj; // downcasting;
        return this.id == otherAnimal.id;
    }
}


