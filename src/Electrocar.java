// Классы можно создавать рядом с другими классами,
// внутри других классов и внутри методов.

public class Electrocar {
	private int	id;

	/*  Вложенные классы: */
	// 1. Нестатический вложенный класс
	private class Motor {
		public void startMototr() {
			System.out.println("Motor "+id+" is starting...");
	// Такие классы относятся к объекту
		}
	}

	// 2. Статический вложенный класс
	public static class Battery {
		// Не имеет доступа к полям объекта
		public void charge(){
			System.out.println("Battery is charging...");
		}
	}

	// 3. Вложенные классы в методе

	public Electrocar(int id) {
		this.id = id;
	}

	public void start() {
		Motor motor = new Motor();
		motor.startMototr();

		final int x = 1;
		class SomeClass {
			public void someMethod(){
				System.out.println(x + " " + id);
			}
		}
		System.out.println("Electrocar "+id+" isstarting...");
	}
}
