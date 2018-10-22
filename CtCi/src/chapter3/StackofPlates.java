package chapter3;

import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

public class StackofPlates {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private static class StackPlateNode {
    	private StackNode<Integer> top;
    	private int occupied; // The number of node in stack 
    	
    	public StackPlateNode() {
    		occupied = 0;
    	}
    	
    }
        
    /* Maximum number of node in one stack */
    private static int threshold = 4;
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
 	    	
        StackNode<Integer> t = new StackNode<>(item);
        
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
    		System.out.println("Stack index " + i);
    		for (StackNode<Integer> n = stacks[i].top; n != null; n = n.next) {
        		System.out.print(n.data + " ");
        	}
        	System.out.println();
    	}
    	
    }
    
    public int pop() {

    	if (stacks[curIdx].occupied == 0) {

    	    if (curIdx == 0) {
    	        throw new EmptyStackException();
            } else {
                curIdx--;
                return pop();
            }
        } else {

    	    int item = stacks[curIdx].top.data;
            stacks[curIdx].top = stacks[curIdx].top.next;
            stacks[curIdx].occupied--;
            return item;
        }
    }

    public int popAt(int idx) {
        if (idx > curIdx) {
            throw new IndexOutOfBoundsException();
        }

        if (stacks[idx].occupied == 0) {
            throw new EmptyStackException();
        } else {
            int item = stacks[idx].top.data;
            stacks[idx].top = stacks[idx].top.next;
            stacks[idx].occupied--;
            return item;
        }
    }
        
    public static void main(String[] args) {
    	StackofPlates sp = new StackofPlates();
    	sp.push(1); sp.push(2); sp.push(3); sp.push(4);
        sp.push(5); sp.push(6); sp.push(7); sp.push(8);
        sp.push(9); sp.push(10); sp.push(11); sp.push(12);
        sp.push(13); sp.push(14); sp.push(15); sp.push(16);
        sp.push(17); sp.push(18); sp.push(19); sp.push(20);

        sp.popAt(3); sp.popAt(3); sp.popAt(3); sp.popAt(3);
        sp.popAt(1); sp.popAt(1);

        sp.pop();sp.pop();sp.pop(); /*sp.pop();*/
    	
    	sp.print();
    } 
    
}