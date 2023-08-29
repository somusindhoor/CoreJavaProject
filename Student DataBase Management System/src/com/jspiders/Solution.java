package com.jspiders;
import java.util.Scanner;
import com.studentexception.InvalidChoiceException;

public class Solution 
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
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		System.out.println("Welcome to Student DataBase Project");

		System.out.println("------------------------------------------------");

		while(true) {

			System.out.println("1:addStudent\n2:displayStudent\n3:displayAllStudents");
			System.out.println("4:removeStudent\n5:removeAllStudents\n6:updateStudent");
			System.out.println("7:countStudents\n8:sortStudents\n9:EXIT");
			System.out.println("Enter the Choice ");
			int choice=sc.nextInt();

			switch(choice) {
			case 1 :
				sms.addStudent();
				break;

			case 2 :
				sms.displayStudent();
				break;

			case 3 :
				sms.displayAllStudents();
				break;

			case 4 :
				sms.removeStudent();
				break;

			case 5 :
				sms.removeAllStudents();
				break;

			case 6 :
				sms.updateStudent();
				break;

			case 7 :
				sms.countStudents();
				break;

			case 8 :
				sms.sortStudents();
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
