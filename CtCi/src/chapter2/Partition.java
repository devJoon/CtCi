package chapter2;

public class Partition extends LinkedList {
	
	/* */
	public void partitionWith(int val) {
		
		Node prev, cur;
		Node gHead, gTail;
		
		/* If list is empty or contains only one element, do nothing */
		if (this.head == null || this.head.next == null)
			return;
		
		/* Initialize node variable */
		prev = null;
		cur = this.head;
		gHead = null;
		gTail = null;
		
		while (cur != null) {
			
			/* when current node's data is greater or equal to value,
		       delete current node from list and append it to the 'greater' list */
			if (cur.data >= val) {
				/* when head node needs to be partitioned */
				if (prev == null) {
					this.head = cur.next;
				}
				else {
					prev.next = cur.next;
				}
				/* insert current node into greater list */
				if (gHead == null) {
					gHead = cur;
					gTail = cur;
				} else {
					gTail.next = cur;
					gTail = gTail.next; // must invalidate last gTail.next
				}				
			} else {
				prev = cur;
			}			
			
			cur = cur.next;
		}
		
		/* nullify last element's next node to prevent loop */
		if (gTail != null)
			gTail.next = null;
		
		/* After partitioning list, connect two list 
		 * If every element in the list is greater than the partitioning value,
		 * prev is null and we must change list head to gHead.
		 */
		
		if (prev != null)
			prev.next = gHead;
		else
			this.head = gHead;
		
	}
	
	public static void main(String args[]) {
		Partition p = new Partition();
		p.insertNodes(10);
		p.printList();
		
		System.out.println("Partition Starts");
		p.partitionWith(5);
		p.printList();
	}
}
