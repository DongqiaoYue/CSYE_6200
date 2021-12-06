package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("\n************************ PRINT OUT STACK ************************\n");
		Stack stack = new Stack();
		stack.demo();
		GenericStack.demo();
		System.out.println("\n************************ PRINT OUT QUEUE ************************\n");
		Queue queue = new Queue();
		queue.demo();
		GenericQueue.demo();
	}
}




//************************ PRINT OUT STACK ************************
//
//Add element: 1
//Add element: 2
//Add element: 3
//Add element: 22
//Add element: 45
//The top element is 45
//Remove element: 45
//Remove element: 22
//The stack size is 3
//The stack isn't empty.
//
//String Stack: 
//Add element: A
//Add element: B
//Add element: C
//Add element: D
//Add element: E
//Remove element: E
//Remove element: D
//The top element: C
//The stack size: 3
//The stack capacity: 5
//
//Double Stack: 
//Add element: 1.0
//Add element: 2.0
//Add element: 3.0
//Add element: 4.0
//Add element: 5.0
//Remove element: 5.0
//Remove element: 4.0
//The top element: 3.0
//The stack size: 3
//The stack capacity: 5
//
//Integer Stack: 
//Add element: 1
//Add element: 2
//Add element: 3
//Add element: 4
//Remove element: 4
//Remove element: 3
//The top element is 2
//The stack size is 2
//The stack capacity: 24
//
//************************ PRINT OUT QUEUE ************************
//
//Add: 645
//Add: 45
//Add: 867
//The front element: 645
//Remove: 645
//The front element: 45
//The Queue size: 2
//Remove: 45
//Remove: 867
//The Queue is empty
//
//String Queue: 
//Add element:  Ha
//Add element:  Haha
//Add element:  Hahaha
//Add element:  Hahahaha
//The front element is Ha
//The Queue size: 4
//The Queue capacity: 4
//Remove element: Ha
//Remove element: Haha
//Remove element: Hahaha
//Remove element: Hahahaha
//If the queue is empty: true
//
//Double Queue: 
//Add element:  1.12
//Add element:  9.57
//The front element is 1.12
//The Queue size: 2
//The Queue capacity: 4
//Remove element: 1.12
//Remove element: 9.57
//If the Queue is empty: true
//
//Integer Queue: 
//Add element:  1
//Add element:  2
//Add element:  3
//Add element:  4
//The front element is null
//The Queue size: 0
//The Queue capacity: 4
//Remove element: 1
//Remove element: 2
//Remove element: 3
//Remove element: 4
//If the queue is empty: true