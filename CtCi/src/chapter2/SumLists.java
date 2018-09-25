package chapter2;

public class SumLists extends LinkedList{

	/* SumLists */
	public static LinkedList add(LinkedList l1, LinkedList l2) {
		int i1 = 0, i2 = 0;
		int p = 0;
		int sum;
		
		for(Node iter=l1.head; iter != null; iter=iter.next) {
			i1 += iter.data * Math.pow(10, p++);
		}            
		System.out.println(i1);
		
		p = 0;
		for(Node iter=l2.head; iter != null; iter=iter.next) {
			i2 += iter.data * Math.pow(10, p++);
		}            
		System.out.println(i2);
		
		sum = i1 + i2;
		System.out.println("sum : " + sum);
		
		// insert from rightmost digit 
		LinkedList resultList = new LinkedList();
		
		while (sum > 0) {
			resultList.appendToTail(sum % 10);
			sum /= 10;
		}
		
		return resultList;
	}
	
	/* SumLists - FOLLOW UP */
	public static LinkedList add2(LinkedList l1, LinkedList l2) {
		int i1 = 0, i2 = 0;
		int p = 0;
		int sum;
		
		for(Node iter=l1.head; iter != null; iter=iter.next) {
			i1 *= 10;
			i1 += iter.data;
		}            
		System.out.println(i1);
		
		p = 0;
		for(Node iter=l2.head; iter != null; iter=iter.next) {
			i2 *= 10;
			i2 += iter.data;
		}            
		System.out.println(i2);
		
		sum = i1 + i2;
		System.out.println("sum : " + sum);
		
		// insert from leftmost digit 
		LinkedList resultList = new LinkedList();
		
		while (sum > 0) {
			resultList.appendToHead(sum % 10);
			sum /= 10;
		}
		
		return resultList;
	}
	
	public static void main(String args[]) {
		
		LinkedList list1 = new LinkedList();
		list1.insertNodes(8);
		list1.printList();
		
		LinkedList list2 = new LinkedList();
		list2.insertNodes(8);
		list2.printList();
		
		System.out.println();
		System.out.println("add result : ");        
        SumLists.add(list1, list2).printList();
        
        System.out.println();
        System.out.println("add2 result : ");
        SumLists.add2(list1, list2).printList();
	}	
}
