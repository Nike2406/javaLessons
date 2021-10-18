/*
* Сериализация - процесс записи объектов в файл
* Десериализация - процесс чтения объектов из файла
* */

// В проекте может быть множество входных точек в программу

import java.io.Serializable;

public class Person implements Serializable {
	// Также необходимо разрешить jave сер-ть объекты
	private int	id;
	private String	name;

	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String toString() {
		return id+" : "+name;
	}
}
