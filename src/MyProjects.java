public class MyProjects {
    public static void main(String [] args) {
        Person person1 = new Person();
        String s1 = "Mike";
        person1.setName(s1);
        person1.setAge(20);
        person1.sayHello();
        person1.speak();
    }
    /*
    * Обращаться к параметра объектов можно напрямую через
    * person1.age = 10;
    * Но данный подход нарушает принцип инкапусуляции
    * Правильнее обращаться через метод для избежания ввода
    * не корректных данных
    */
    static class Person{
        String  name;
        int     age;

        void    setName(String userName){
            name = userName;
        }
        void    setAge(int userAge){
            age = userAge;
        }
        void speak(){
            System.out.println("My name is "+name+", i'm "+age+" years old.");
        }
        void    sayHello(){
            System.out.println("Hello!");
        }
    }
}
