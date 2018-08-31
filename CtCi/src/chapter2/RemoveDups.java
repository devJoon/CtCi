package chapter2;

import java.util.HashMap;
import java.util.Map;

public class RemoveDups extends LinkedList{

	/* removeDuplicate node using HashMap class*/
    public void removeDuplicate() {
    	Map<Integer, Boolean> nodeMap = new HashMap<Integer, Boolean>();
    	
    	Node prev, cur;
    	
    	prev = this.head;
    	cur = this.head;
    	
    	// empty list
    	if (cur == null)
    		return;
    	
    	// contains only one data : no duplication
    	if (cur.next == null)
    		return;
    	
    	// head node data is put and cur proceeds
    	nodeMap.put(cur.data, true);
    	cur = cur.next;
    	    	
    	while(cur != null) {
    		
    		// duplicate found 
    		if (nodeMap.get(cur.data) != null) {
    			
    			// middle node
    			
    			prev.next = cur.next;
    			cur = cur.next;
    			    			    			
    			// tail node : would be same as middle node
    			
    		} else {
    			nodeMap.put(cur.data, true);
    			prev = cur;
    			cur = cur.next;
    		}    		
    	}
    }
    
    /* removeDuplicate node without using extra data structure */
    public void removeDuplicateInplace() {
    	
    	for (Node pivot = this.head; pivot != null; pivot = pivot.next) {
    		Node prev = pivot;
    		Node cur = pivot.next;
    		
    		while (cur != null) {
    			if (pivot.data == cur.data) {
    				prev.next = cur.next;
    				cur = cur.next;
    			} else {
    				prev = cur;
        			cur = cur.next;
    			}
    		}    		
    	}
    }

    public static void main(String args[]){
    	RemoveDups list;
        list = new RemoveDups();
        list.insertNodes(20);
        list.printList();
        
        // list.removeDuplicate();
        
        list.removeDuplicateInplace();
        
        list.printList();
    }
}
