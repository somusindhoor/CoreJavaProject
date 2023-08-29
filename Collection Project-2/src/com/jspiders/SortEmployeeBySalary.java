package com.jspiders;
import java.util.Comparator;

public class SortEmployeeBySalary implements Comparator<Employee> 
{

	@Override
	public int compare(Employee x, Employee y) {
		Double i=x.getSalary();
		Double j=y.getSalary();
		return  i.compareTo(j);
	}
}
//if return type of getSalary() is non-primitive Double use
//make the Employee class in getter() as public double getSalary(){return salary;}
//return  x.getSalary().compareTo(y.getSalary()); --->Correct 

//x -> object to be inserted & y -> already existing object.
