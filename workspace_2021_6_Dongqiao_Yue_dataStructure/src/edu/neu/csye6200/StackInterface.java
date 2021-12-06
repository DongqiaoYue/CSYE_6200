package edu.neu.csye6200;

public interface StackInterface<E> {

    StackInterface<E> push(E element);

    E pop();

    E peek();
    
    public int size();
 
    public Boolean isEmpty();
 
    public Boolean isFull();
}
