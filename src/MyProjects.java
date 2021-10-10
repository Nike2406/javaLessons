public class MyProjects {
    public static void main(String [] args) {
        int number = 10; // примитивный тип данных       [10]
        int[] numbers = new int[5]; // ссылочный тип данных
        // numbers->[array]

//        numbers[0] = 10;
//        numbers[1] = 20;
//        int[] numbers = {1;2;3};

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 5;
        }
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        System.out.println(number);
        System.out.println();

        // foreach
        // Позволяет перебрать весь массив
        String[] strings = new String[3];
        for (String x:strings){
            System.out.println(x);
        }
        /*
        * Где String - тип данных
        * x - временная переменная (counter)
        * strings - имя массива
        */
    }
}
