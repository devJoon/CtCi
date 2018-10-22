package chapter3;


public class SortStack {
	
	private MyStack<Integer> stack;

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
			while( sorted.isEmpty() || (stack.peek() < sorted.peek()) ) {
				sorted.push(stack.pop());
			}
			
			tmp.push(stack.pop());
			
			while (sorted.isEmpty() != true) {
				stack.push(sorted.pop());
			}
			
			sorted.push(tmp.pop());
			
			stack.print();
			tmp.print();
			sorted.print();
			
		}				
	}
	

	public static void main(String[] args) {
		SortStack sstack = new SortStack();
		sstack.stack.push(4);
		sstack.stack.push(2);
		sstack.stack.push(3);
		sstack.stack.push(1);
		sstack.stack.push(9);
		sstack.stack.push(7);
		
		sstack.sort();

	}

}
