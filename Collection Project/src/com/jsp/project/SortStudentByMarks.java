package com.jsp.project;
import java.util.Comparator;

public class SortStudentByMarks implements Comparator<Student> 
{
	@Override
	public int compare(Student m1, Student m2) {
		return (int) (m1.getMarks()-m2.getMarks());
	}	
}
