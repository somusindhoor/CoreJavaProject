package com.jspiders.Employee;
import java.util.Scanner;

public class SolutionEmployee 
{
	public static void main(String[] args) 
	{
		// Menu Driven Program
		// UPCASTING
		// switch case
		// System.exit(0);
		// Infinite loop -> while(true){}
		// Create a Custom Exception & Invoke it -> ClassName -> InvalidChoiceException

		// To Accept Input from User
		Scanner sc=new Scanner(System.in);

		// UPCASTING For Achieving ABSTRACTION
		EmployeeManagementSystem emp=new EmployeeManagementSystemImpl();
		System.out.println("Welcome to Employee DataBase Project");

		System.out.println("------------------------------------------------");

		while(true) {

			System.out.println("1:addEmployee\n2:displayEmployee\n3:displayAllEmployees");
			System.out.println("4:removeEmployee\n5:removeAllEmployees\n6:updateEmployee");
			System.out.println("7:countEmployees\n8:sortEmployees\n9:EXIT");
			System.out.println("Enter the Choice ");
			int choice=sc.nextInt();

			switch(choice) {
			case 1 :
				emp.addEmployee();
				break;

			case 2 :
				emp.displayEmployee();
				break;

			case 3 :
				emp.displayAllEmployees();
				break;

			case 4 :
				emp.removeEmployee();
				break;

			case 5 :
				emp.removeAllEmployees();
				break;

			case 6 :
				emp.updateEmployee();
				break;

			case 7 :
				emp.countEmployees();
				break;

			case 8 :
				emp.sortEmployees();
				break;

			case 9 : 
				System.out.println("Thank You!!! ");
				System.exit(0);

			default :	
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("-----------------------"); // After Switch Statement
		}
	}
}

