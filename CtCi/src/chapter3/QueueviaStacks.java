package chapter3;

/* Implement queue by using two stacks */
public class QueueviaStacks<T> {
	private MyStack<T> main;
	private MyStack<T> temp;
	private Boolean reversed;
	
	public QueueviaStacks() {
		main = new MyStack<T>();
		temp = new MyStack<T>();
		reversed = false;
	}
	
	public void add(T item) {
		if (reversed == true) {
			migrate(temp, main);	
		}
		reversed = false;
		main.push(item);
	}
	
	public T remove() {
		if (reversed == false) {
			migrate(main, temp);
		}
		reversed = true;
		return temp.pop();
	}
	
	/* Move data from stack a to b. (order is reversed) */
	private void migrate(MyStack<T> a, MyStack<T> b) {
		while(a.getTop() != null) {
			b.push(a.pop());
		}
	}
	
	public static void main(String[] args) {
		QueueviaStacks<Integer> qs = new QueueviaStacks<>();
		qs.add(1);qs.add(2);qs.add(3);qs.add(4);
		System.out.println(qs.remove());
		qs.add(5);
		System.out.println(qs.remove());
	}
}
