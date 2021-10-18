import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadObject {
	public static void main(String[] args) {
		try {
			// Обратная процедура
			FileInputStream fis = new FileInputStream("people.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// 1. Вариант
//			int personCount = ois.readInt();
//			Person[] people = new Person[personCount];
//			for (int i = 0; i < personCount; i++) {
//				people[i] = (Person) ois.readObject();
//			}
			// 2. Вариант
			Person[] people = (Person[]) ois.readObject();

			System.out.println(Arrays.toString(people));

			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
