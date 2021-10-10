public class MyProjects {
    public static void main(String [] args) {
        Person person1 = new Person();
        person1.setName("Kira");
        person1.setAge(15);
        person1.sayHello();
        person1.speak();
        System.out.println(person1.getAge());
        System.out.println(person1.getName());
    }
    /*
    * Пользователю необходимо давать только внешний интерфейс
    * устройства программы, который не затрагивает значения переменных,
    * к тому же можно ограничивать ввод
    */
    static class Person{
        private String  name; //private - переменная видна только в пределах класса
        private int     age;

        // Setter - устанавливает значения
        public void    setName(String userName){
            if (userName.isEmpty())
                System.out.println("Please, put in Name");
            else
                name = userName;
        }
        // Getter - возвращает значения
        public String getName(){
            return name;
        }

        public void    setAge(int userAge){
            if (userAge < 0)
                System.out.println("Error! Incorrect age!");
            else
                age = userAge;
        }
        public int getAge(){
            return age;
        }

        void speak(){
            System.out.println("My name is "+name+", i'm "+age+" years old.");
        }
        void    sayHello(){
            System.out.println("Hello!");
        }
    }
}
