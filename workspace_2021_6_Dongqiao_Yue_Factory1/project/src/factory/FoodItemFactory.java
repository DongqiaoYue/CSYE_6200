package factory;

public class FoodItemFactory {
	
	public static FoodItem getItem(String str) {
		
		if(str == null) {
			
			return null;
			
		}
	    
		
		return new FoodItem(str);
 
	}
		
}
