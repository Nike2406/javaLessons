/*
* Любой класс в Java наследуется от класса Object
* */
public class MyProjects {
    public static void main(String[] args){
        Human h1 = new Human("Bob", 40);
        System.out.println(h1);
        h1.toString(); // возвращает хешкод созданного объекта
    }
}
class  Human {
    private String  name;
    private int     age;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){ // переопределение метода объекта
        return name+", "+age;
    }
}

