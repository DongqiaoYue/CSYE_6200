package edu.neu.csye6200;


public class GenericStack<T> implements StackInterface<T>{

	private T stackArr[];
    private int top;
    private int capacity;
    
    // set to prevent OutOfMemoryErrors.
    public static final int MAX_SIZE = Integer.MAX_VALUE - 24;
    
    public GenericStack() {
    	// default size
        this(24);
    }
    
 // Constructor to initialize the stack
    public GenericStack(int capacity) {

        if (capacity > MAX_SIZE) {
        	System.exit(1);
        }

		T[] tempData = (T[]) new Object[capacity];
        this.stackArr = tempData;
        this.capacity = capacity;
        this.top = -1;
    }
 
    
	@Override
	public StackInterface<T> push(T element) {
		if (isFull()) {
            System.exit(1);
        }
 
        System.out.println("Add element: " + element);
        this.stackArr[++top] = element;
        return this;
	}

	@Override
	public T pop() {
        if (isEmpty()) {
        	System.exit(1);
        }
 
        System.out.println("Remove element: " + peek());
 
        return this.stackArr[top--];
	}

	@Override
	public T peek() {
		if (isEmpty()) {
            System.exit(1);
        }
 
        return this.stackArr[top];
	}

	@Override
	public int size() {
		 return this.top + 1;
	}

	@Override
	public Boolean isEmpty() {
    	if (this.top == -1) {
    		return true;
    	} else {
    		return false;
    	}
	}

	@Override
	public Boolean isFull() {
    	if (size() == this.capacity) {
    		return true;
    	} else {
    		return false;
    	}
	}
	
	public static void demo() {
    	GenericStack<String> stringStack = new GenericStack<>(5);
    	System.out.println("\nString Stack: ");
    	
    	stringStack.push("A");
    	stringStack.push("B");
    	stringStack.push("C");
    	stringStack.push("D");
    	stringStack.push("E");
    	
    	stringStack.pop();
    	stringStack.pop(); 
    	
        System.out.println("The top element: " + stringStack.peek());
        System.out.println("The stack size: " + stringStack.size());
        System.out.println("The stack capacity: " + stringStack.capacity);
        
    	GenericStack<Double> doubleStack = new GenericStack<>(5);
    	System.out.println("\nDouble Stack: ");
    	
    	doubleStack.push(1.0);      
    	doubleStack.push(2.0);      
    	doubleStack.push(3.0);      
    	doubleStack.push(4.0);      
    	doubleStack.push(5.0);
    	
    	doubleStack.pop();        
    	doubleStack.pop();     
 
        System.out.println("The top element: " + doubleStack.peek());
        System.out.println("The stack size: " + doubleStack.size());
        System.out.println("The stack capacity: " + doubleStack.capacity);
        
    	GenericStack<Integer> integerStack = new GenericStack<>();
    	System.out.println("\nInteger Stack: ");
    	
    	integerStack.push(1);
    	integerStack.push(2);
    	integerStack.push(3); 
    	integerStack.push(4);
 
    	integerStack.pop();
    	integerStack.pop();
 
        System.out.println("The top element is " + integerStack.peek());
        System.out.println("The stack size is " + integerStack.size());
        System.out.println("The stack capacity: " + integerStack.capacity);

    }

}
