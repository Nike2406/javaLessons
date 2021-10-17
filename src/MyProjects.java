import java.io.File;
import java.io.FileNotFoundException; // наследуется от класса Exception
import java.util.Scanner;

public class MyProjects {
    public static void main(String[] args) throws FileNotFoundException {
        // throws FileNotFoundException - выбрасывает код ошибки

        // Исключения созданы для обработки ошибок
        // Все классы исключений наследуются от класса Exception
     File file = new File("ew");
     Scanner scanner = new Scanner(file);

     // также возможна обработка через  try/catch
        // попробуй одно, если не получилось, сделай другое
//        try {
//            Scanner scanner1 = new Scanner("ijwef");
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден");
//        }
    }
}


