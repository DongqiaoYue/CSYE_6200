package zoo;

/**
 * used to implement the abstract class
 * @author Dongqiao Yue
 *
 */
public class ZooAbstractAnimals {
	
	abstract class AbstractAnimalAPI {
		
		public abstract String animalSleep();
		
		public String animalEat() {
		    
			return "yummy~yummy~";
			
		}
		
	}
	
	public class Dog extends AbstractAnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "zzzzzz~";
			
		}
		
	}
	
	public class Cat extends AbstractAnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "meomeomeomeomeo~";
			
		}
		
	}
	
	public class Fish extends AbstractAnimalAPI {
		
		@Override
		public String animalSleep() {
			
			return "pupupupupupu~";
			
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
		
		ZooAbstractAnimals animal = new ZooAbstractAnimals();
		
		System.out.println(animal.toString());
		
	}
	
	
}


