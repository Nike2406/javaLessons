import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* Работа с массивами объектов */

public class WriteObject {
	public static void main(String[] args) {
		Person[] people = {
			new Person(1, "Bob"),
			new Person(2, "Mike"),
			new Person(3, "Tom"),
		};
		try {
			FileOutputStream fos = new FileOutputStream("people.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// 1. Вариант
//			oos.writeInt(people.length);
//			for(Person person : people) {
//				oos.writeObject(person);
//			}
			// 2. Вариант
			oos.writeObject(people);

			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
