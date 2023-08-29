package com.jspiders;

//public class -> Student
//private attributes as private-> id,age,name & marks
//public constructor -> age,name & marks, id-> generate automatically
//public 3 setter() & 4 getter()
//public toString()

public class Student 
{
	private String id;
	private  String name;
	private int age;
	private  int marks;

	static int count=101;

	public Student(String name, int age, int marks) {
		this.id = "JSP"+count;
		this.name = name;
		this.age = age;
		this.marks = marks;
		count++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks;
	}
}