package Interfaces;

// implements = реализует (т.е. классы должны испльзовать метод showInfo)
public class Animal implements Info {
    public int id;

    public Animal(int id) {
        this.id = id;
    }

    public void sleep(){
        System.out.println("I'm sleeping");
    }

    public void showInfo() {
        System.out.println("Id is "+this.id);
    }
}
