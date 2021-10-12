package Interfaces;

// implements = реализует (т.е. классы должны испльзовать метод showInfo)
public class Human implements Info{
    public String name;

    public Human(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello!");
    }

    public void showInfo() {
        System.out.println("Name is "+this.name);
    }
}
