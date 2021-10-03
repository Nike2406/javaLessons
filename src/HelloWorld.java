import java.util.Arrays;

public class HelloWorld {
    public static void main(String [] args) {
        int myInt1 = 10;
        short myInt2;
        long myInt3;

        double myInt4;
        float myInt5;

        char c = 'c';
        System.out.println(myInt1);
    }
    /*
    byte (целые числа, 1 байт)  -128 до 127
    short (целые числа, 2 байта) -32768 до 32767
    int (целые числа, 4 байта) -2147483648 до 2147483647
    long (целые числа, 8 байтов) -9223372036854775808 до 9223372036854775807
    float (вещественные числа, 4 байта) ~1,4*10-45 до ~3,4*1038
    double (вещественные числа, 8 байтов)  ~4,9*10-324  до ~1,8*10308
    char (символ Unicode, 2 байта)  ‘\ u0000’ (0) - ‘\ uffff’(65535)
    boolean (значение истина/ложь, 1 байт) true/false
*/
}
