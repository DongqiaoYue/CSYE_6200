package factory;

public class ElectronicItemFactory  {
	
	private static ElectronicItem electronicItem = null;
	 
	ElectronicItemFactory() {}
	 
	public static ElectronicItem getItem(String str) {
		   
		if (electronicItem == null) {  
			
			electronicItem = new ElectronicItem(str);  
			
		}
		
		return electronicItem;
	
	}
 
}

