public class Cat extends Animal{
	// Для создания конкретного объекта класса
	// необходимо наследоваться от этого класса
	@Override
	public void makeSound() {
		System.out.println("Moew");
	}
}
