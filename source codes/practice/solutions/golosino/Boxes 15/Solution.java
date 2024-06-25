import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayStack<Integer> stack = new ArrayStack<>();
        int count = 1;
        String choice = s.next();

        while (!"END".equals(choice)) {
            switch (choice) {
                case "PUSH":
                    int num = s.nextInt();  
                    if (num >= 1 && num <= 1000) {
                        stack.push(num);
                    }
                    break;
                case "TOP":
                    if (stack.isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        System.out.println(stack.top());
                    }
                    break;
                case "POP":
                    stack.pop();
                    break;
                default:
                    break;
            }
            if(count == 1000) {
                break;
            }
            choice = s.next();
            count++;
        }
    }
}

class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY=1000; // default array capacity
    private E[ ] data; // generic array used for storage
    private int t = -1; // index of the top element in stack
    
    public ArrayStack( ) { this(CAPACITY); } // constructs stack with default capacity
    
    public ArrayStack(int capacity) { // constructs stack with given capacity
        data = (E[ ]) new Object[capacity]; // safe cast; compiler may give warning
    }
    
    public int size( ) { return (t + 1); }
    
    public boolean isEmpty( ) { return (t == -1); }
    
    public void push(E e) throws IllegalStateException {
        if (size( ) == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e; // increment t before storing new item
    }
    
    public E top( ) {
        if (isEmpty( )) return null;
        return data[t];
    }
    
    public E pop( ) {
        if (isEmpty( )) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return null;
    }
    
    public void display() {
        for(E d: data) {
            System.out.println(d);
        }
    }
    
    public void clear() {
        data = null;
    }
}

interface Stack<E> {

    /**
    * Returns the number of elements in the stack.
    * @return number of elements in the stack
    */
    int size( );

    /**
    * Tests whether the stack is empty.
    * @return true if the stack is empty, false otherwise
    */
    boolean isEmpty( );

    /**
    * Inserts an element at the top of the stack.
    * @param e the element to be inserted
    */
    void push(E e);

    /**
    * Returns, but does not remove, the element at the top of the stack.
    * @return top element in the stack (or null if empty)
    */
    E top( );

    /**
    * Removes and returns the top element from the stack.
    * @return element removed (or null if empty)
    */
    E pop( );
    
    void display();
    
    void clear();
 }
