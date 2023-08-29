package com.jspiders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.customException.InvalidChoiceException;
import com.customException.ProductNotFoundException;
import SortingLogic.SortProductByCost;
import SortingLogic.SortProductById;
import SortingLogic.SortProductByName;
import SortingLogic.SortProductByQuantity;


public class DepartmentalStoreImpl implements DepartmentalStore {

	Scanner sc=new Scanner(System.in);
	Map<String,Product> db = new LinkedHashMap<String,Product>();

	@Override
	public void addProduct() {
		// Accept name,cost,quantity
		// Create an instance of Product
		// Add into db -> put() -> Entry
		System.out.println("Enter the Product Name :");
		String name=sc.next();
		System.out.println("Enter the Product Cost :");
		int cost=sc.nextInt();
		System.out.println("Enter the Product Quantity :");
		int quantity=sc.nextInt();

		Product p=new Product(name,cost,quantity);
		db.put(p.getId(), p);
		System.out.println("Product Inserted Successfully!");

	}

	@Override
	public void removeProduct() {
		System.out.println("Enter the Product Id: ");
		String id=sc.next();
		id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Product Deleted Successfully");
		}
		else {
			try {
				throw new ProductNotFoundException("Product Records Not Found!");
			}
			catch(ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllProducts() {
		System.out.println(db.size()+" Products Present ");
		db.clear();
		System.out.println("All Products are Deleted");
	}

	@Override
	public void displayProduct() {
		// Accept Product Id
		// Check if id is present or not -> containsKey()
		// Invoke an Exception -> ProductNotFoundException

		System.out.println("Enter the Product Id: ");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)){ // OR if(db.containsKey(sc.next()))
			Product obj=db.get(id);
			System.out.println("Id: "+obj.getId());
			System.out.println("Name: "+obj.getName());
			System.out.println("Cost: "+obj.getCost());
			System.out.println("Quantity: "+obj.getQuantity());
		}
		else {
			try {
				throw new ProductNotFoundException("Products Not Present");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllProducts() {
		// Map into keySet
		// get()
		Set<String> keys=db.keySet();// "JSP101" "JSP102"
		System.out.println("Products are as Follows:  ");
		System.out.println("-------------------------------");
		if(db.size()!=0) {
			for(String key : keys) {
				//				Product p=db.get(key);
				//				System.out.println(p);    OR
				System.out.println(db.get(key));//Printing reference variable
			}
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Available to Display");
			}
			catch(ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateProduct() {

		/**
		 * Accept Id & Converted to UpperCase
		 * containsKey() , get the Product Object
		 * switch case 1:update name, 2:Cost, 3:Quantity
		 * invoke Exception
		 */
		System.out.println("Enter the Product Id: ");
		String id=sc.next().toUpperCase(); 
		if(db.containsKey(id)) {
			Product p=db.get(id);
			System.out.println("1:Update Name\n2:Update Cost\n3:Update Quantity");
			System.out.println("Enter the Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Product Name: ");
				String name=sc.next();
				p.setName(name);
				System.out.println("Product Name Updated Successfully");
				break;

			case 2:
				System.out.println("Enter Product Cost: ");
				p.setCost(sc.nextInt());// int age=sc.nextInt();
				System.out.println("Product Cost Updated Successfully");
				break;

			case 3:
				System.out.println("Enter Product Quantity: ");
				p.setQuantity(sc.nextInt());
				System.out.println("Product Quantity Updated Successfully");
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new ProductNotFoundException("Student Record Not Found! ");
			}
			catch(ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countProducts() {
		System.out.println("Total Number of Product Records: "+db.size());
	}

	@Override
	public void sortProducts() {
		/**
		 * Converting Map into Set -> keySet()
		 * keys are Product Id and  datatype is String 
		 */
		Set<String> keys=db.keySet();// "JSP101" "JSP102"

		/**
		 * Achieving Upcasting between List & ArrayList
		 * list can store Product objects 
		 */
		List<Product> list=new ArrayList<Product>();

		/**
		 * for-each,get the values(Product  objects) and store into ArrayList
		 */
		for(String key : keys) {
			list.add(db.get(key));
		}

		System.out.println("1:SortProductBy Id\n2:SortProductBy Name");
		System.out.println("3:SortProductBy Cost\n4:SortProductBy Quantity");
		System.out.println("Enter the Choice");
		int choice=sc.nextInt();
		
		System.out.println("1:Ascending Order\n2:Descending Order");
		System.out.println("Enter the Choice");
		int input=sc.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(list,new SortProductById());
			//			for(Product p : list) {
			//				System.out.println(p);
			//			}
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);
			break;

		case 2:
			if(input==1) {
			Collections.sort(list,new SortProductByName());
			}
			//			for(Product p : list) {
			//				System.out.println(p);
			//			}
			else {
				Collections.reverse(list);
			}
			display(list);
			break;

		case 3:
			Collections.sort(list,new SortProductByCost());
			//			for(Product p : list) {
			//				System.out.println(p);
			//			}
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);
			break;

		case 4:
			Collections.sort(list,new SortProductByQuantity());
			//			for(Product p : list) {
			//				System.out.println(p);
			//			}
			if(input==2) {
				Collections.reverse(list);
			}
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
	private static void display(List<Product> list){
		for(Product p : list) {
			System.out.println(p);
		}
	}
}
