package com.jspiders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.sortinglogic.StudentSortByAge;
import com.sortinglogic.StudentSortById;
import com.sortinglogic.StudentSortByMarks;
import com.sortinglogic.StudentSortByName;
import com.studentexception.*;

/***
 * 
 * @author SOMU
 * @since 2022
 *
 * We are adding implementation for 8 abstract methods StudentManagementSystem 
 *
 */

public class StudentManagementSystemImpl implements StudentManagementSystem  
{
	/**
	 * Collection -> DataBase & Map ->  LinkedHashMap-> key(String) -> value(Student)
	 * Use Scanner

	 */
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	Scanner sc=new Scanner(System.in);

	@Override
	public void addStudent() {
		/**
		 * Accept name,age & marks & then create Student Object
		 */
		System.out.println("Enter the student name: ");
		String name=sc.next();
		System.out.println("Enter the Student Age: ");
		int age=sc.nextInt();
		System.out.println("Enter the Student Marks: ");
		int marks=sc.nextInt();

		Student s=new Student(name,age,marks);
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student Id is "+s.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter the Student Id: ");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)){ // OR if(db.containsKey(sc.next()))
			Student obj=db.get(id);
			System.out.println("Id: "+obj.getId());
			System.out.println("Name: "+obj.getName());
			System.out.println("Age: "+obj.getAge());
			System.out.println("Marks: "+obj.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {
		/**
		 * Map -> Set of keys
		 * for -> get()
		 */
		Set<String> keys=db.keySet();// "JSP101" "JSP102"
		System.out.println("Student Records are as Follows:  ");
		System.out.println("-------------------------------");
		if(db.size()!=0) {
			for(String key : keys) {
				System.out.println(db.get(key));//Printing reference variable
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Available to Display");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {

		/**
		 * Accept the Id
		 * Converted to UpperCase
		 * ContainsKey()
		 *  remove()
		 *  else -> StudentNotFoundException -> handle
		 */
		System.out.println("Enter the Student Id: ");
		// String id=sc.next().toUpperCase(); [OR]
		String id=sc.next();
		id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record Not Found! ");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		System.out.println(db.size()+" Student Record Present ");
		db.clear();
		System.out.println("All Student Records are Deleted");
	}

	@Override
	public void updateStudent() {

		/**
		 * Accept Id & Converted to UpperCase
		 * containsKey() , get the Student Object
		 * switch case 1:update name, 2:age, 3:marks
		 * invoke Exception
		 */
		System.out.println("Enter the Student Id: ");
		String id=sc.next().toUpperCase(); 
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter the Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Student Name: ");
				String name=sc.next();
				std.setName(name);
				System.out.println("Student Name Updated Successfully");
				break;

			case 2:
				System.out.println("Enter Student Age: ");
				std.setAge(sc.nextInt());// int age=sc.nextInt();
				System.out.println("Student Age Updated Successfully");
				break;

			case 3:
				System.out.println("Enter Student Marks: ");
				std.setMarks(sc.nextInt());
				System.out.println("Student Marks Updated Successfully");
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record Not Found! ");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudents() {
		System.out.println("Total Number of Student Records: "+db.size());
	}

	@Override
	public void sortStudents() {
		/**
		 * Converting Map into Set -> keySet()
		 * keys are Student Id and  datatype is String 
		 */
		Set<String> keys=db.keySet();// "JSP101" "JSP102"

		/**
		 * Achieving Upcasting between List & ArrayList
		 * list can store Student objects 
		 */
		List<Student> list=new ArrayList<Student>();

		/**
		 * for-each,get the values(Student objects) and store into ArrayList
		 */
		for(String key : keys) {
			list.add(db.get(key));
		}

		System.out.println("1:SortStudentBy Id\n2:SortStudentBy Name");
		System.out.println("3:SortStudentBy Age\n4:SortStudentBy Marks");
		System.out.println("Enter the Choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new StudentSortById());
			//			for(Student s : list) {
			//				System.out.println(s);
			//			}
			display(list);
			break;

		case 2:
			Collections.sort(list,new StudentSortByName());
			//			for(Student s : list) {
			//				System.out.println(s);
			//			}
			display(list);
			break;

		case 3:
			Collections.sort(list,new StudentSortByAge());
			//			for(Student s : list) {
			//				System.out.println(s);
			//			}
			display(list);
			break;

		case 4:
			Collections.sort(list,new StudentSortByMarks());
			//			for(Student s : list) {
			//				System.out.println(s);
			//			}
			display(list);
			break;

		default :
			try {
				throw new InvalidChoiceException("Invalid Choice");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Student> list){
		for(Student s : list) {
			System.out.println(s);
		}
	}
}
