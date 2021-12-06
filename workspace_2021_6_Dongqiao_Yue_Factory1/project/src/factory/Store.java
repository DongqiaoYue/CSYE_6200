package factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Store {
	
	public static void demo() {
		
		ServiceItem service = ServiceItemFactory.getItem();
		ElectronicItem electronic = ElectronicItemFactory.getItem("70010,GraphicCards,1000");
		FoodItem food = FoodItemFactory.getItem("10004,Pear,20");
		
		List<Item> lists = new ArrayList<Item>();
		
		lists.add(electronic);
		lists.add(service);
		lists.add(food);
		
		Store store = new Store();
		
		System.out.println("----------------------------Sort by ID----------------------------");
		List<Item> IDRes = store.sortItemBy(lists, new IDComparator());
		store.printObjects(IDRes);
		System.out.println("----------------------------Sort by Name----------------------------");
		List<Item> nameRes = store.sortItemBy(lists, new nameComparator());
		store.printObjects(nameRes);
		System.out.println("----------------------------Sort by Price----------------------------");
		List<Item> priceRes = store.sortItemBy(lists, new priceComparator());
		store.printObjects(priceRes);
		
	}
	
	public List<Item> sortItemBy(List<Item> s, Comparator<Item> p) {	
		
		Collections.sort(s, p);
		
		return s;
		
	}
	
	public void printObjects(List os) {
		
		for (Object o : os) {
			
			System.out.println(o);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store.demo();
	}
	
}

class IDComparator implements Comparator<Item> {
		
	@Override
	public int compare(Item a, Item b) {
		return a.getID() < b.getID() ? -1 : a.getID() == b.getID() ? 0 : 1;
	}
		
}

class priceComparator implements Comparator<Item> {
		
	@Override
	public int compare(Item a, Item b) {
		return a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1;
	}
		
}

class nameComparator implements Comparator<Item> {
		
	@Override
	public int compare(Item a, Item b) {
		return a.getName().compareTo(b.getName());
	}
		
}

//----------------------------Sort by ID----------------------------
//FoodItem [ID=10004, Name=Pear, Price=20]
//ElectronicItem [ID=70010, Name=GraphicCards, Price=1000]
//ServiceItem [ID=90002, Name=soap, Price=10]
//----------------------------Sort by Name----------------------------
//ElectronicItem [ID=70010, Name=GraphicCards, Price=1000]
//FoodItem [ID=10004, Name=Pear, Price=20]
//ServiceItem [ID=90002, Name=soap, Price=10]
//----------------------------Sort by Price----------------------------
//ServiceItem [ID=90002, Name=soap, Price=10]
//FoodItem [ID=10004, Name=Pear, Price=20]
//ElectronicItem [ID=70010, Name=GraphicCards, Price=1000]
