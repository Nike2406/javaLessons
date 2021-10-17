import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyProjects {
    public static void main(String[] args) {
        // Checked exception (Compile time exception)
        //      - исключения, которые возникают во время компиляции
        // Unchecked exception (Runtime exception)
        //      - возникают во время работы программы

        //checked - исключительный случай
        File file = new File("test");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //unchecked - ошибка
        int a = 1 / 0;
        String name = null;
        name.length();

        int[] arr = new int[2];
        System.out.println(arr[2]);
    }
}


