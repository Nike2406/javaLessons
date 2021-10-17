import java.io.IOException;
import java.util.Scanner;

public class MyProjects {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());
            // у объекта Integer, метод parseInt переводит строку в число

//            if (x != 0) {
//                try {
//                    throw new IOException();
//                } catch (IOException e) {
//                    System.out.println("Не 0!");
//                }
//            }
            if (x != 0){
                throw new ScannerException("Не 0!");
            }
        }
    }
}


