package edu.neu.csye6200;


public class GenericQueue<T> implements QueueInterface<T>{

	private T[] data;
    private int front;
    private int size;
    private int back;
    private int capacity;

    public static final int MAX_SIZE = Integer.MAX_VALUE - 24;

    public GenericQueue() {
        this(24);
    }

    public GenericQueue(int capacity) throws IllegalArgumentException {

        if (capacity > MAX_SIZE) {
            System.exit(1);
        }
        
        T[] tempData = (T[]) new Object[capacity];
        this.data = tempData;
        this.capacity = capacity;
    }

    @Override
    public QueueInterface<T> enqueue(T e) throws IllegalArgumentException {
        if (size == data.length) {
        	System.exit(1);
        }

        data[back] = e;
        this.back = (back + 1) % capacity;
        this.size ++;
        System.out.println("Add element:  " + e);
        return this;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
        	System.exit(1);
        }

        size --;
    	System.out.println("Remove element: " + data[front]);
        T output = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        return output;
    }

    @Override
    public T peek() {
    	if (size == 0) {
    		return null;
    	} else {
    		return data[front];
    	}
    }
    
    @Override
	public int size() {
    	return size;
	}

	@Override
	public Boolean isEmpty() {
		if (size() == 0) {
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
    	GenericQueue<String> stringQueue = new GenericQueue<>(4);
    	System.out.println("\nString Queue: ");
    	 
    	stringQueue.enqueue("Ha");
    	stringQueue.enqueue("Haha");
    	stringQueue.enqueue("Hahaha");
    	stringQueue.enqueue("Hahahaha");
    	
    	System.out.println("The front element is " + stringQueue.peek());
    	System.out.println("The Queue size: " + stringQueue.size());
    	System.out.println("The Queue capacity: " + stringQueue.capacity);
    	
    	stringQueue.dequeue();
    	stringQueue.dequeue();
    	stringQueue.dequeue();
    	stringQueue.dequeue();
  
    	System.out.println("If the queue is empty: " + stringQueue.isEmpty());
    	
    	GenericQueue<Double> doubleQueue = new GenericQueue<>(2);
    	System.out.println("\nDouble Queue: ");
    	 
    	doubleQueue.enqueue(1.12);
    	doubleQueue.enqueue(9.57);
    	
    	System.out.println("The front element is " + doubleQueue.peek());
    	System.out.println("The Queue size: " + doubleQueue.size());
    	System.out.println("The Queue capacity: " + stringQueue.capacity);
    	
    	doubleQueue.dequeue();
    	doubleQueue.dequeue();
    	System.out.println("If the Queue is empty: "+ doubleQueue.isEmpty());
    	
    	GenericQueue<Integer> integerQueue = new GenericQueue<>();
    	System.out.println("\nInteger Queue: ");
    	
    	integerQueue.enqueue(1);
    	integerQueue.enqueue(2);
    	integerQueue.enqueue(3);
    	integerQueue.enqueue(4);
    	
    	System.out.println("The front element is " + doubleQueue.peek());
    	System.out.println("The Queue size: " + doubleQueue.size());
    	System.out.println("The Queue capacity: " + stringQueue.capacity);
    	
    	integerQueue.dequeue();
    	integerQueue.dequeue();
    	integerQueue.dequeue();
    	integerQueue.dequeue();
    	System.out.println("If the queue is empty: "+ doubleQueue.isEmpty());
    	
    }
}
