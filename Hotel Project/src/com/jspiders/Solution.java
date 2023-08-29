package com.jspiders;
import java.util.Scanner;
import com.Exception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {

		System.out.println("Welcome to XYZ Hotel");
		System.out.println("-----------------------------");

		Scanner sc=new Scanner(System.in);
		HotelManagementSystem hotel = new HotelManagementSystemImpl();

		hotel.addFood();//Adding All Food Dishes into the Database(Map)

		System.out.println("-------------------------");

		int input = 1; 

		while(input == 1) {

			System.out.println("1:Order Food\n2:CheckOut");
			System.out.println("Enter the Choice:");
			int choice =sc.nextInt();

			System.out.println("---------------------");

			switch(choice) {
			case 1:
				hotel.displayFood();
				hotel.orderFood();
				break;

			case 2:
				hotel.checkOut();
				System.out.println("Thank You!!!");
				System.exit(0);

			default :
				try {
					throw new InvalidChoiceException("Invalid Choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}//End of switch

			System.out.println("----------------------");
			System.out.println("Enter 1 to Continue, Any Other Number to Exit");
			input=sc.nextInt();
		}//End of while
		hotel.checkOut();
		System.out.println("Thank You!");
	
	}
}
