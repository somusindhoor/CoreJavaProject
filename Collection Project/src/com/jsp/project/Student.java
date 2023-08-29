package com.jsp.project;

public class Student 
{
	private int id;
	private String name;
	private double marks;

	public Student(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", marks=" + marks;
	}
}
