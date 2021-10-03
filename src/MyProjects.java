import java.util.Scanner;

/*
 * new - ключевое слово создания нового объекта класса
 * scanner - ввод данных с консоли
 *
 * Разные классы находятся в разных пакетах:
 * String - java.lang; (Импортируются заранее)
 * Scanner - java.util (Теперь тоже импортируется заранее);
 * import java.util.Scanner;
 * */

public class MyProjects {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Press put in");
        String string = s.nextLine();
        System.out.println("You put: "+string);
    }
}
