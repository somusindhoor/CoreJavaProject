package com.jsp.ac;

public interface Bank 
{
	void deposit(int amount);
	void withdraw(int amount);
	int getBalance();
	String displayErrorMessage();

}
//all the methods in interface are automatically pu