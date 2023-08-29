package com.jsp.pjt;

public class CalculatorImpl implements Calculator 
{

	@Override
	public String add(int a, int b) {
		int sum=a+b;
		return "Sum of "+a+" & "+b+" is "+sum;
	}
	@Override
	public String sub(int a, int b) {
		return"Difference  of "+a+" & "+b+" is "+(a-b);
	}
	@Override
	public String mul(int a, int b) {	
		return "Product of "+a+" & "+b+" is "+(a*b);
	}
	@Override
	public String div(int a, int b) {
		if(b!=0) {
			return "Division  of "+a+" & "+b+" is "+(a/b);
		}
		else {
			return "Invalid Denominator!";	
		}
	}
	@Override
	public String displayErrorMessage() {
		return "Invalid Choice, Please Enter Valid Choice!!!";
	}
}
