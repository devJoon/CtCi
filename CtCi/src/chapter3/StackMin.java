package chapter3;

import java.util.EmptyStackException;
import java.util.Random;

public class StackMin<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        private T minVal;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return  item;
    }

    /* To get a minimum value in O(1) time, 
     * compute minimum value each time we push a node and store it in minVal.
     * Each StackNode has minVal, meaning the minimum value of the stack up to the current node.
     */
    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        
        if (top == null) {
        	t.minVal = t.data;
        }
        else {
        	/* Generic does not support operator overloading.
        	 * For simplicity, we assume that T is of type Integer.
        	 */
        	if ((Integer)t.data < (Integer)top.minVal  ) {
        		t.minVal = t.data;
        	}
        	else
        		t.minVal = top.minVal;
        }        
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }
    
    public T min() {
    	if (top == null) throw new EmptyStackException();
    	System.out.println("min : " + top.minVal);
        return top.minVal;
    }

    public boolean isEmpty() {
        return top == null;
    }
    
    public void print() {
    	
    	/* Print data */
    	for (StackNode<T> n = this.top; n != null; n = n.next) {
    		System.out.print(n.data + " ");
    	}
    	System.out.println();
    	
    	/* Print minimum value */
    	for (StackNode<T> n = this.top; n != null; n = n.next) {
    		System.out.print(n.minVal + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	StackMin<Integer> stack = new StackMin<>();
    	
    	Random random = new Random();
    	
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	stack.push(random.nextInt(10));
    	
    	stack.print();
    	
    	/*stack.min();
    	stack.pop();*/
    }
}