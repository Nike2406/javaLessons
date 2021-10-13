import Packege1.Person;

/*
* 4 модификатора доступа:
* public, private, default, protected
* */
public class Test {
    // public int id;
    // разрешает доступ к полю везде на протяжении прокта
    // В одном java-файле не может быть двух public классов

    // private int id;
    // разрешает доступ к полю только в классе, где он был объявлен

    // default() - когда не ставится модификатор доступа
    // class Test {}
    // default() - доступно в пределах пакета

    // protected - доступны всем подклассам, даже если они вне
    // пакета, где они были задиклорированы (при условии
    // наследования класса)

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Bob";
    }
}
