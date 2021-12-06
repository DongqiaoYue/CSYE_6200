package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FoodItem implements Item {
	
	private int ID;
	private String Name;
	private int Price;
	
	
	public FoodItem(String food) {
		
		Scanner in = new Scanner(food);
		in.useDelimiter(",");
		
		this.ID = in.nextInt();
		this.Name = in.next();
		this.Price = in.nextInt();
			
		FoodItem item = new FoodItem();
		
		in.close();

	}
	
	public FoodItem(int ID, String Name, int Price) {
		
		this.ID = ID;
		this.Name = Name;
		this.Price = Price;
		
	}
	
	public FoodItem() {
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
	
	@Override
	public String toString() {
		return "FoodItem [ID=" + ID + ", Name=" + Name + ", Price=" + Price + "]";
	}
	

}
