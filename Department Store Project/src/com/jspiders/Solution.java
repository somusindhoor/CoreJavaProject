package com.jspiders;
import java.util.Scanner;
import com.customException.InvalidChoiceException;

public class Solution {
	static private void displayMenu() {
		System.out.println("1.addProduct\n2.removeProduct\n3.removeAllProducts");
		System.out.println("4.displayProduct\n5.displayAllProducts\n6.updateProduct");
		System.out.println("7.countProducts\n8.sortProducts\n9.EXIT");
	}
	public static void main(String[] args) {
		// Menu-Driven Program -> 9 Option
		// Switch
		// com.customException -> InvalidChoiceException

		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome To Departmental Store");
		System.out.println("-----------------------------------");
		DepartmentalStoreImpl store=new DepartmentalStoreImpl();

		//		System.out.println("1.addProduct\n2.removeProduct\n3.removeAllProducts");
		//		System.out.println("4.displayProduct\n5.displayAllProducts\n6.updateProduct");
		//		System.out.println("7.countProducts\n8.sortProducts\n9.EXIT");

		while(true) {
			displayMenu();
			System.out.println("Enter the Choice: ");
			int choice = sc.nextInt();

			switch(choice) {
			case 1 :
				store.addProduct();
				break;

			case 2 :
				store.removeProduct();
				break;

			case 3 :
				store.removeAllProducts();
				break;

			case 4 :
				store.displayProduct();
				break;

			case 5 :
				store.displayAllProducts();
				break;

			case 6 :
				store.updateProduct();
				break;

			case 7 :
				store.countProducts();
				break;

			case 8 :
				store.sortProducts();
				break;

			case 9 :
				System.out.println("Thank You...");
				System.exit(0);

			default :
				try {
					throw new InvalidChoiceException("Invalid Choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("------------------------------------------");
		}
	}
}
