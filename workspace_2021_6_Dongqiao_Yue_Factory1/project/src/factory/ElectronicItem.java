package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ElectronicItem implements Item {

	private int ID;
	private String Name;
	private int Price;

	
	public ElectronicItem(String electronic) {
		
		Scanner in = new Scanner(electronic);
		in.useDelimiter(",");
		
		this.ID = in.nextInt();
		this.Name = in.next();
		this.Price = in.nextInt();
			
		ElectronicItem item = new ElectronicItem();
		
		in.close();

	}
	
	public ElectronicItem(int ID, String Name, int Price) {
		
		this.ID = ID;
		this.Name = Name;
		this.Price = Price;
		
	}

	public ElectronicItem() {
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
		return "ElectronicItem [ID=" + ID + ", Name=" + Name + ", Price=" + Price + "]";
	}

}
