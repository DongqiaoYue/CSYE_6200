package factory;

public class ServiceItemFactory {
	
	private static ServiceItem serviceItem = new ServiceItem("90002,soap,10");  
	    
	ServiceItemFactory() {}  
	    
	public static ServiceItem getItem() {  
	    
		return serviceItem;
	    
	}
	
}
