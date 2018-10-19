package chapter3;

import java.util.EmptyStackException;

public class StackofPlates {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
    
    /* can we make this class to extend StackNode<Integer> ?*/
    private static class StackPlateNode {
    	private StackNode<Integer> top;
    	private int occupied; // The number of node in stack 
    	
    	public StackPlateNode() {
    		occupied = 0;
    	}
    	
    }
        
    /* Maximum number of node in one stack */
    private static int threshold = 3;    
    /* Maximum number of stack */
    private static int MaxNumberofStack = 10;    
    private StackPlateNode[] stacks;
    private int curIdx;
    
    
    public StackofPlates() {
    	stacks = new StackPlateNode[MaxNumberofStack];
    	for (int i=0; i<MaxNumberofStack; i++)
    		stacks[i] = new StackPlateNode();
    	curIdx = 0;
    }
    
    public void push(int item) {
 	    	
        StackNode<Integer> t = new StackNode<Integer>(item);
        
        if (stacks[curIdx].occupied == threshold) {
        	
        	if (curIdx == MaxNumberofStack - 1) {
        		throw new StackOverflowError(); 
        	} else {
        		curIdx++;
        	}
        }
        
        t.next = stacks[curIdx].top;
        stacks[curIdx].top = t;
        stacks[curIdx].occupied++;
    }
    
    public void print() {
    	System.out.println("The number of stack : " + (curIdx + 1));
    	
    	for(int i= curIdx; i>=0; i--) {
    		System.out.println("Stack number " + (i+1));
    		for (StackNode<Integer> n = stacks[i].top; n != null; n = n.next) {
        		System.out.print(n.data + " ");
        	}
        	System.out.println();
    	}
    	
    }
    
    /*public int pop() {
    	
    	if (stacks[curIdx].occupied)
    	
    	
    	
    	
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return  item;
    }*/
        
    public static void main(String[] args) {
    	StackofPlates sp = new StackofPlates();
    	sp.push(1);
    	sp.push(2);
    	sp.push(3);
    	sp.push(4);
    	
    	sp.print();
    }
    
}