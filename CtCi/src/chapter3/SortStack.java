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

		MyStack<Integer> tmp;
		MyStack<Integer> sorted;
		
		tmp = new MyStack<>();
		sorted = new MyStack<>();
		
		while (stack.isEmpty() != true) {			
			while( sorted.isEmpty() || (stack.peek() <= sorted.peek()) ) {
				sorted.push(stack.pop());
				
				
				/*System.out.print("stack : ");
				stack.print();
				
				System.out.print("temp : ");
				tmp.print();
				
				System.out.print("sorted : ");
				sorted.print();*/
				
				
				if (stack.isEmpty()) {
					break;
				}				
			}
			
			if (stack.isEmpty()) {
				break;
			}
			
			tmp.push(stack.pop());
			
			
			/*System.out.print("stack : ");
			stack.print();
			
			System.out.print("temp : ");
			tmp.print();
			
			System.out.print("sorted : ");
			sorted.print();*/
			
			
			while (sorted.isEmpty() != true) {
				stack.push(sorted.pop());
				
				/*System.out.print("stack : ");
				stack.print();
				
				System.out.print("temp : ");
				tmp.print();
				
				System.out.print("sorted : ");
				sorted.print();*/
			}
			
			sorted.push(tmp.pop());
			
			/*System.out.print("stack : ");
			stack.print();
			
			System.out.print("temp : ");
			tmp.print();
			
			System.out.print("sorted : ");
			sorted.print();*/
			
		}
						
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
