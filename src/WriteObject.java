import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		Person person1 = new Person(1, "Bob");
		Person person2 = new Person(2, "Mike");

		// Serialisation
		try {
			FileOutputStream fos = new FileOutputStream("people.bin");
			// FileOutputStream - запись последовательности байтов в файл
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// ObjectOutputStream - только запись объектов

			// Непосредственно запись
			oos.writeObject(person1);
			oos.writeObject(person2);

			// закрытие потока
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
