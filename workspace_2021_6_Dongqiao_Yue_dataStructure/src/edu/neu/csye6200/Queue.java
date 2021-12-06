package edu.neu.csye6200;

public class Queue {
	
	private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
	
    public Queue() {}
    
	public Queue(int size) {
		arr = new int[size];
		capacity = size; // Max size
		front = 0;
		rear = -1;
		count = 0; // elements in Queue
	}
	
	 // Utility function to dequeue the front element
    public void dequeue()
    {
        // check for queue underflow
        if (isEmpty()) {
            System.exit(1);
        }
 
        System.out.println("Remove: " + arr[front]);
 
        front = (front + 1) % capacity;
        count--;
    }
 
    // Utility function to add an item to the queue
    public void enqueue(int item)
    {
        // check for queue overflow
        if (isFull()) {
            System.exit(1);
        }
 
        System.out.println("Add: " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // return the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.exit(1);
        }
        return arr[front];
    }
 
    // return the size of the queue
    public int size() {
        return count;
    }
 
    // check if the queue is empty
    public Boolean isEmpty() {
        if (size() == 0) {
        	return true;
        } else {
        	return false;
        }
    }
 
    // check if the queue is full
    public Boolean isFull() {
    	if (size() == capacity) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void demo() {
        Queue q = new Queue(4);
 
        q.enqueue(645);
        q.enqueue(45);
        q.enqueue(867);
 
        System.out.println("The front element: " + q.peek());
        q.dequeue();
        System.out.println("The front element: " + q.peek());
        System.out.println("The Queue size: " + q.size());
 
        q.dequeue();
        q.dequeue();
 
        if (q.isEmpty()) {
            System.out.println("The Queue is empty");
        } else {
            System.out.println("The Queue isn't empty");
        }
    }
}
