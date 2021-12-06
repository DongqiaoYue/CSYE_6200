package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceItem implements Item {

	private int ID;
	private String Name;
	private int Price;

	
	public ServiceItem(String service) {
		
		Scanner in = new Scanner(service);
		in.useDelimiter(",");
		
		this.ID = in.nextInt();
		this.Name = in.next();
		this.Price = in.nextInt();
			
		ServiceItem item = new ServiceItem();
		
		in.close();

	}
	
	public ServiceItem(int ID, String Name, int Price) {
		
		this.ID = ID;
		this.Name = Name;
		this.Price = Price;
		
	}
	
	public ServiceItem() {
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
		return "ServiceItem [ID=" + ID + ", Name=" + Name + ", Price=" + Price + "]";
	}
	

}
