package com.jsp.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainClassStudent 
{
	public static void main(String[] args) 
	{
		Student s1=new Student(20,"John",47);
		Student s2=new Student(40,"Jack",52);
		Student s3=new Student(50,"Alex",98);
		Student s4=new Student(30,"King",120);
		Student s5=new Student(10,"Smith",35);

		Map<Integer,Student> map=new LinkedHashMap<Integer,Student>();
		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		map.put(s4.getId(), s4);
		map.put(s5.getId(), s5);

		//Convert Map into a Set of Keys 
		Set<Integer> s=map.keySet();//20 40 50 30 10

		System.out.println("Entries present inside Map");
		for(int key : s) {
			System.out.println(map.get(key)); //printing s1 s2 s3 s4 s5
		}

		System.out.println("-----------------------------");

		//Add the values from the Map into ArrayList
		List<Student> l=new ArrayList<Student>();

		for(int key : s)
		{ 
			Student obj=map.get(key);//Student obj=new Student(10,"A",23);
			l.add(obj);
			//		l.add(map.get(key));	getting  s1 s2 s3 s4 s5
		}
		System.out.println("Objects present in List ");
		for(Student std:l)
		{
			System.out.println(std);
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Sort By Id\n2.Sort By Name\n3.Sort By Marks");
		System.out.println("Enter Choice ");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			SortStudentById a=new SortStudentById();
			Collections.sort(l,a);
			for(Student std : l) {
				System.out.println(std);
			}
			break;
			
		case 2:
			//SortStudentByName b=new SortStudentByName();
			Collections.sort(l,new SortStudentByName());
			for(Student std : l) {
				System.out.println(std);
			}
			break;
			
		case 3:
			 SortStudentByMarks c=new  SortStudentByMarks();
			 Collections.sort(l,c);
			 for(Student std : l) {
					System.out.println(std);
				}
			 break;
			
		default :
			System.out.println("Invalid Choice! ");
			
		}
	}
}
