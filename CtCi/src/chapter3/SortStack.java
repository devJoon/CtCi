package chapter3;

import java.util.Random;

public class SortStack {
	
	private MyStack<Integer> stack;

	public MyStack<Integer> getStack() {
		return stack;
	}

	public SortStack() {
		stack = new MyStack();
	}
	
	/* Sort the stack. Minimum element goes top. */
	public void sort() {

		int tmp;
		MyStack<Integer> sorted;
				
		sorted = new MyStack<>();
		
		while (stack.isEmpty() != true) {			
			while( sorted.isEmpty() || (stack.peek() <= sorted.peek()) ) {
				sorted.push(stack.pop());
									
				if (stack.isEmpty()) {
					break;
				}				
			}
			
			if (stack.isEmpty()) {
				break;
			}
			
			tmp = stack.pop();
			
			/* Can be improved to fit tmp into location at this stage.*/
			while (sorted.isEmpty() != true) {
				stack.push(sorted.pop());				
			}
			
			sorted.push(tmp);						
		} /* end of outer while */ 
						
		stack = sorted;				
	}
	

	public static void main(String[] args) {
		SortStack sstack = new SortStack();
		
		Random rnd = new Random();
		int stackSize = 10;
		
		for(int i=0; i<stackSize; i++) {
			sstack.getStack().push(rnd.nextInt(50));
		}
		sstack.stack.print();
		sstack.sort();	
		sstack.stack.print();

	}

}
