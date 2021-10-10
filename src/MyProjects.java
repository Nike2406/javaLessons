public class MyProjects {
    public static void main(String[] args){
        Human human1 = new Human("Bob", 20);
        // Если удалить пустой констроктор, то мы больше
        // не сможем создавать новые элементы класса через
        // пустые скобки
        human1.setAge(18);
        human1.setName("Tom");
    }
}
class Human{
/*
* Конструктор создается для создания значеий
* 1. В отличие от метода, у конструктора нет
* возваращаемого значения.
* 2. Имя конструктора должно совпадать с именем
* класса и начинается с большой буквы.
*/
    String  name;
    int     age;

    // constructor
    public Human(){
        this.name = "Имя по умолчанию";
        this.age = 0;
        System.out.println("Привет из первого конструктора!");
    }
    public Human(String name, int age){ // constructor
        System.out.println("Привет из второго конструктора!");
        this.name = name;
        this.age = age;
    }
    // Перегрузка методов - множество методов с одинаковым называнием,
    // но с разными параметрами
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}
