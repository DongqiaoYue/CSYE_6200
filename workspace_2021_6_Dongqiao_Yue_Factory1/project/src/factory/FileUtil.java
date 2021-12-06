package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
	
	public void writeCSV(List<String> list, String str) {
		
		try {
			FileWriter fw = new FileWriter(str);
			BufferedWriter out= new BufferedWriter(fw);
			for (String strs : list) {
				out.write(strs);
				out.newLine();
			}
			out.flush();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<FoodItem> readFoodItemCSV() {
		
		List<FoodItem> foods = new ArrayList<FoodItem>();
		
		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader("./src/factory/FoodItemCSV.txt")));
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
				in.useDelimiter(",");
				
				int ID = in.nextInt();
				String Name = in.next();
				int Price = in.nextInt();
				
				foods.add(new FoodItem (ID, Name, Price));
				in.close();
			}
			
			inLine.close();   
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
		}
		
		return foods;
		
	}
	
	public List<ServiceItem> readServiceItemCSV() {
			
		List<ServiceItem> services = new ArrayList<ServiceItem>();
			
		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader("./src/factory/ServiceItemCSV.txt")));
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
				in.useDelimiter(",");

				int ID = in.nextInt();
				String Name = in.next();
				int Price = in.nextInt();
					
				services.add(new ServiceItem (ID, Name, Price));
				in.close();
			}
				
			inLine.close();   
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
		}
			
		return services;
			
	}

	public List<ElectronicItem> readElectronicItemCSV() {
		
		List<ElectronicItem> electronics = new ArrayList<ElectronicItem>();
		
		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader("./src/factory/ElectronicItemCSV.txt")));
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
				in.useDelimiter(",");

				int ID = in.nextInt();
				String Name = in.next();
				int Price = in.nextInt();
				
				electronics.add(new ElectronicItem (ID, Name, Price));
				in.close();
			}
			
			inLine.close();   
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
		}
		
		return electronics;
		
	}

	
	public static void demo() {
		
		// write
		List<String> foodItemList = new ArrayList<String>();
		foodItemList.add("10001,Apple,10");
		foodItemList.add("10002,Strawberry,10");
		foodItemList.add("10003,Watermelon,10");
		foodItemList.add("10004,Grape,15");
		
		List<String> electronicItemList = new ArrayList<String>();
		electronicItemList.add("70001,CPU,800");
		electronicItemList.add("70002,GPU,900");
		electronicItemList.add("70003,Mouse,850");
		electronicItemList.add("70004,Keyboard,600");
		
		List<String> serviceItemList = new ArrayList<String>();
		serviceItemList.add("90801,Pillow,100");
		serviceItemList.add("90802,Towel,150");
		serviceItemList.add("90803,Suit,160");
		serviceItemList.add("90804,Glasses,250");
		
		FileUtil util = new FileUtil();
		
		util.writeCSV(foodItemList, "./src/factory/FoodItemCSV.txt");
		util.writeCSV(electronicItemList, "./src/factory/ElectronicItemCSV.txt");
		util.writeCSV(serviceItemList, "./src/factory/ServiceItemCSV.txt");
		
		// read
		List<FoodItem> foods = util.readFoodItemCSV();
		List<ServiceItem> services = util.readServiceItemCSV();
		List<ElectronicItem> electronics = util.readElectronicItemCSV();
		
		System.out.println("--------------------------List of FoodItem------------------------");
		for (FoodItem food : foods) {
			String str = food.toString();
			System.out.println(str);
		}
		
		System.out.println("--------------------------List of ServiceItem------------------------");
		for (ServiceItem service : services) {
			String str = service.toString();
			System.out.println(str);
		}
		
		System.out.println("--------------------------List of ElectronicItem------------------------");
		for (ElectronicItem electronic : electronics) {
			String str = electronic.toString();
			System.out.println(str);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtil.demo();
	}
	
}

//--------------------------List of FoodItem------------------------
//FoodItem [ID=10001, Name=Apple, Price=10]
//FoodItem [ID=10002, Name=Strawberry, Price=10]
//FoodItem [ID=10003, Name=Watermelon, Price=10]
//FoodItem [ID=10004, Name=Grape, Price=15]
//--------------------------List of ServiceItem------------------------
//ServiceItem [ID=90801, Name=Pillow, Price=100]
//ServiceItem [ID=90802, Name=Towel, Price=150]
//ServiceItem [ID=90803, Name=Suit, Price=160]
//ServiceItem [ID=90804, Name=Glasses, Price=250]
//--------------------------List of ElectronicItem------------------------
//ElectronicItem [ID=70001, Name=CPU, Price=800]
//ElectronicItem [ID=70002, Name=GPU, Price=900]
//ElectronicItem [ID=70003, Name=Mouse, Price=850]
//ElectronicItem [ID=70004, Name=Keyboard, Price=600]
