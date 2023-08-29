package com.jsp.ac;
import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Bank bank=new BankImpl(5000);//UPCASTING

		while(true) {
			System.out.println("1.Deposit Amount\n2.Withdraw Amount");
			System.out.println("3.Check Balance\n4.EXIT");
			System.out.println("Enter Choice: ");
			int choice=sc.nextInt();

			switch(choice)
			{
			case 1: 
				System.out.println("Enter Amount to be Deposited: ");
				int amountToDeposit=sc.nextInt();
				bank.deposit(amountToDeposit);//bank.deposit(sc.nextInt());
				break;

			case 2:
				System.out.println("Enter Amount to be Withdrawn: ");
				int amountToWithdraw=sc.nextInt();
				bank.withdraw(amountToWithdraw);//bank.withdraw(sc.nextInt());
				break;

			case 3:
				System.out.println(bank.getBalance());
				break;

			case 4:
				System.out.println("Thank You!");
				System.exit(0);

			default:
				System.out.println(bank.displayErrorMessage());
			}//End of Switch Statement.
		}//End of While Loop.
	}
}
