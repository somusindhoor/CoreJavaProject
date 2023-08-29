package com.jspiders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainClassEmployee 
{
	public static void main(String[] args) 
	{
		Employee e1=new Employee("Somu",2.6);
		Employee e2=new Employee("Kantu",3.7);
		Employee e3=new Employee("Ayappa",4.3);

		Map<String,Employee> map=new LinkedHashMap<String,Employee>();
		// Adding 3 entries
		map.put(e1.getName(),e1);
		map.put(e2.getName(),e2);
		map.put(e3.getName(),e3);

		//Converting Map into a Set of keys
		Set<String> s=map.keySet();//"Somu","Kantu","Ayappa"

		//create an instance of ArrayList
		List<Employee> l=new ArrayList<Employee>();  

		// Adding values(employee object) from Map into ArrayList.
		for(String key : s) {
			l.add(map.get(key));
		}
		//l.add(map.get("Somu"));
		//l.add(map.get("Kantu"));
		//l.add(map.get("Ayappa"));

		// Traversing employee objects from ArrayList.
		for(Employee emp : l) {
			System.out.println(emp);   
		}

		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("1:sortEmployeeByName\n2:sortEmployeeBySalary\n3:EXIT");
		System.out.println("Enter the Choice ");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(l,new SortEmployeeByName());
			for(Employee emp : l) {
				System.out.println(emp);
			}
			break;
			
		case 2:
			Collections.sort(l,new SortEmployeeBySalary());
			for(Employee emp : l) {
				System.out.println(emp);
			}
			break;
			
		case 3:
			System.out.println("Exit");
			System.exit(0);
			
			default :
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
		}
		System.out.println("------------------------");
		}

	}
}
