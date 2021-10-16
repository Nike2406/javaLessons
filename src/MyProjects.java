import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyProjects {
    public static void main(String[] args) throws FileNotFoundException {
        // File.separator - автоматически определяет систему
        // и выводит правильный знак / \
        String separator = File.separator;
       String path = separator+"Users"+separator+"prochell"+
        separator+"projects"+separator+"javaLessons"+separator+"test";
        // Если файл лежит в корне, то проще
        File file2 = new File("test2");
       // File - выводит файл в переменную с адресом
       File file = new File(path);

       // Scanner тажке может считывать файл
       Scanner scanner = new Scanner(file);
       while (scanner.hasNextLine()){
           System.out.println(scanner.nextLine());
       }
       scanner.close();
    }
}


