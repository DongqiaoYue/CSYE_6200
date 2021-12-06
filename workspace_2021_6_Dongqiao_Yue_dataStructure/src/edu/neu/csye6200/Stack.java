package edu.neu.csye6200;

public class Stack {
    private int stackArr[];
    private int top;
    private int capacity;
    
    Stack() {}
    
    Stack(int size) {
    	stackArr = new int[size];
        capacity = size;
        top = -1;
    }
 
    // add an element
    public void push(int x) {
        if (isFull()) {
            System.exit(1);
        }
 
        System.out.println("Add element: " + x);
        
        stackArr[++top] = x;
    }
 
    // pop a top element
    public int pop() {
        if (isEmpty()) {
            System.exit(1);
        }
 
        System.out.println("Remove element: " + peek());
 
        return stackArr[top--];
    }
 
    // return the top element
    public int peek() {
    	
        if (isEmpty()) {
            System.exit(1);
        }
 
        return stackArr[top];
    }
 
    // return the size of the stack
    public int size() {
        return top + 1;
    }
 
    // check if the stack is empty
    public Boolean isEmpty() {
    	if (top == -1) {
    		return true;
    	} else {
    		return false;
    	}
    }
 
    // check if the stack is full
    public Boolean isFull() {
    	if (size() == capacity) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void demo() {
    	Stack stack = new Stack(5);
        
    	stack.push(1);      
        stack.push(2);    
        stack.push(3);
        stack.push(22);
        stack.push(45);
 
        System.out.println("The top element is " + stack.peek());
        
        stack.pop();        
        stack.pop();        
 
        System.out.println("The stack size is " + stack.size());
 
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack isn't empty.");
        }
    }
}
