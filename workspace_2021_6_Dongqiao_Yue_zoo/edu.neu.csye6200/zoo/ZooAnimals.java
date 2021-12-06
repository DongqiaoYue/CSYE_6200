package zoo;


/**
 * used to implement the concrete class
 * @author Dongqiao Yue
 *
 */
public class ZooAnimals {
	
	public class AnimalAPI {
		
		public String animalSleep() {
			
			return "";
			
		}
		
		public String animalEat() {
			
			return "";
			
		}
		
	}
	
	public class Dog extends AnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "owowowowowo~";
			
		}
		
		@Override
		public String animalEat() {
			
			return "yummy~";
			
		}
		
	}
	
	public class Cat extends AnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "meomeomeomeo~";
			
		}
		
		@Override
		public String animalEat() {
			
			return "yummy~yummy~";
			
		}
		
	}

	public class Fish extends AnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "pupupupupu~";
			
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
		
		ZooAnimals animal = new ZooAnimals();
		
		System.out.println(animal.toString());
		
	}
	
}
