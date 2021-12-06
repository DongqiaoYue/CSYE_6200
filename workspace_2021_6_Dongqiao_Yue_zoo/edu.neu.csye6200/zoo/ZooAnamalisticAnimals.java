package zoo;


/**
 * used to implement the interface
 * @author Dongqiao Yue
 *
 */
public class ZooAnamalisticAnimals {

	interface AnimalisticAPI {
		
		public String animalSleep();
		  
		public String animalEat();
	
	}
	
	public class Dog implements AnimalisticAPI {
		
		@Override
		public String animalSleep() {

			return "zzzzzzzz~";
			
		}
	  
		@Override
		public String animalEat() {
	    	
			return "yummy~";
	    	
		}
	
	}
	
	public class Cat implements AnimalisticAPI {
		
		@Override
		public String animalSleep() {
			
			return "meomeomeomeomeo~";
			
		}
		
		@Override
		public String animalEat() {
			
			return "yummy~yummy~";
			
		}
		
	}
	
	public class Fish implements AnimalisticAPI {
		
		@Override
		public String animalSleep() {
			
			return "pupupupupupupu~";
			
		}
		
		@Override
		public String animalEat() {
			
			return "yummy~yummy~yummy~";
			
		}
		
	}
	
	/**
	 * the toString() method
	 */
	@Override
	public String toString() {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		Fish fish = new Fish();
		
		
		return "ZooAnimals [toString()=" + super.toString() + ";Dog:" + dog.animalEat() + ";" + dog.animalSleep() + ";Cat:" + cat.animalEat() + ";" + cat.animalSleep() + ";Fish:" + fish.animalEat() + ";" + fish.animalSleep() + "]";
		
	}
	
	public static void demo() {
		
		ZooAnamalisticAnimals animal = new ZooAnamalisticAnimals();
		
		System.out.println(animal.toString());
		
	}

}
