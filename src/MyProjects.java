/*
* В Java есть два типа объектов:
*  - mutable - изменяемый
*  - immutable - неизменяемый
*  String - immutable type
* */
public class MyProjects {
    public static void main(String[] args){
        String x = "Hello";
        x.toUpperCase(); // - возвращает новую строку
        System.out.println(x);
        x = x.toUpperCase();
        System.out.println(x);

        String str1 = "Hi";
        String str2 = " my";
        String str3 = " friend.";
        String stringAll = str1+str2+str3;
        // Выполняется сначала сложение первых двух и создается нрвоый элемент,
        // потом к получившемуся эл-ту прибавляется третий (долго, затратно)
        System.out.println(stringAll);

        StringBuilder sb = new StringBuilder("Hello sb");// - mutable
        System.out.println(sb.toString());
        sb.append(" yo!"); // изменяется метод StringBuilder (быстрее, не выделяется новой пмяти*)
        System.out.println(sb.toString());
    }
}

