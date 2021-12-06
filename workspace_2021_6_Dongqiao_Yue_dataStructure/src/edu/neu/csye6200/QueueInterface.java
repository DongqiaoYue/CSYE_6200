package edu.neu.csye6200;

public interface QueueInterface<E> {
	
    QueueInterface<E> enqueue(E element);
    
    E dequeue();
    
    E peek();
    
    public int size();
    
    public Boolean isEmpty();
    
    public Boolean isFull();
}
