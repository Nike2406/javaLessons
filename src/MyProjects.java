import java.util.ArrayList;
import java.util.List;

/*
ArrayList - хранит в себе объекты
* */
public class MyProjects {
    public static void main(String[] args) {
        ///// Java 5 ////
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");

//      String animal = animals.get(1); - необходим downcast
        // для корректновго вывода, тк все объекты наследуются от
        // клсасса Object
        String animal = (String) animals.get(1); // downcast
        System.out.println(animal);

        //// Generics ////
        List<String> animals2 = new ArrayList<String>();
        // в <> указывается тип, класс, который будет помещаться в List
        animals2.add("cat");
        animals2.add("dog");
        animals2.add("frog");
        String animal2 = animals2.get(1);


        /////// Java 7 ///////
        List<String> animals3 = new ArrayList<>();
        // В правой части можно не указывать тип параметра
    }
}


