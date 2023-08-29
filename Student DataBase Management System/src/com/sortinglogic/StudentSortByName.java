package com.sortinglogic;
import java.util.Comparator;
import com.jspiders.Student;

public class StudentSortByName implements Comparator<Student> 
{
	@Override
	public int compare(Student x, Student y) {
		return x.getName().compareTo(y.getName());
	}
}
