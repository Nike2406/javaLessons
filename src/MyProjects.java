public class MyProjects {
    public static void main(String[] args){
        Human h1 = new Human("Bob", 40);
        Human h2 = new Human("Tom", 30);
        Human.printHi(); // Метод принадлежит к классу (а не к объекту)
        h1.printNumberOfPeople();
        h2.printNumberOfPeople();
    }
}
/*
* Static - принадлежит к классу
* */
class Human{

    String  name;
    int     age;

    private static int  countPeople; // для всех объектов одна переменная

    public Human(String name, int age){ // constructor
        this.name = name;
        this.age = age;
        countPeople++;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public static void printHi(){
        System.out.println("Hi!");
    }
    public void printNumberOfPeople(){
        System.out.println("Number of people is "+countPeople);
    }
}
