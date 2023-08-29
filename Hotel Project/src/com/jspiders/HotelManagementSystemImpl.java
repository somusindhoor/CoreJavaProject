package com.jspiders;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.Exception.InvalidQuantityException;

public class HotelManagementSystemImpl implements HotelManagementSystem {

	Scanner sc=new Scanner(System.in);
	Map<Integer, Food> db=new LinkedHashMap<Integer, Food>();
	int totalCost=0;
	@Override
	public void addFood() {
		db.put(1, new Food(1,"Chicken Biryani",250,5));
		db.put(2, new Food(2,"Chicken Roll",140,6));
		db.put(3, new Food(3,"Mashroom Biryani",280,4));
		db.put(4, new Food(4,"Fish Biryani",190,6));
		db.put(5, new Food(5,"Mutton Biryani",300,7));
		System.out.println("Food Menu Created");
	}

	@Override
	public void displayFood() {
		Set<Integer> keys =db.keySet();//1 2 3 4 5
		for(int key : keys) {
			System.out.println("Enter "+key+" -> "+db.get(key));
		}
	}

	@Override
	public void orderFood() {
		//1. get the Food object based on id/choice -> get()	
		//2. accept quantity -> set new Quantity
		//3. calculate cost 
		//4. cost -> Total Bill
		//5. InvalidQuantityException

		System.out.println("Select Food:");
		int id=sc.nextInt();
		Food food=db.get(id);
		System.out.println("Ordering: "+food.getName());

		System.out.println("Enter Quantity:");
		int quantity=sc.nextInt();

		if(quantity <= food.getQuantity()) {
			food.setQuantity(food.getQuantity()-quantity);
			int currentCost = food.getCost()*quantity; //480
			totalCost = totalCost + currentCost;
			System.out.println("Ordered "+quantity+" "+food.getName()+
					"at the cost of Rs."+currentCost);
		}
		else {
			try {
				throw new InvalidQuantityException("Invalid Quantity Entered!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void checkOut() {
		if(totalCost !=0) {
			System.out.println("Total Bill: Rs."+totalCost);
		}
		else {
			System.out.println("No food items Added");
		}
	}
}
