/*
* Dog наследуется (extends) от класса Animal
* и имеет все свойства этого класса помимо своих
* */

public class Dog extends Animal {

    public void eat(){
        // переопределение метода
        // т.е. дочерний метод имеет более высокий приоритет
        System.out.println("Dog is eating");
    }

    public void showName() {
        System.out.println(name);;
    }

    public void bark(){
        System.out.println("I'm barking!");
    }
}
