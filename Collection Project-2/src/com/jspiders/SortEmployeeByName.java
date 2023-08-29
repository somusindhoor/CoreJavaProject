package com.jspiders;
import java.util.Comparator;

public class SortEmployeeByName implements Comparator<Employee> 
{

	@Override
	public int compare(Employee x, Employee y) {
		return x.getName().compareTo(y.getName());
	}
}
// x -> object to be inserted & y -> already existing object.