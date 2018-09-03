package chapter2;

import java.util.Random;

// assume that data stored in Node is of type int - how about generic type?
// moved to the Node.java and made it public.
/*class Node {
    int data;
    Node next;

    public Node(int n){
        this.data = n;
    }
}*/


public class LinkedList {
    Node head;

    public LinkedList() {

    }
    
	public LinkedList(Node node) {
        this.head = node;
    }

    public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

    public void appendToTail(int val) {
        Node lastNode = this.head;


        if (lastNode == null) {
            this.head = new Node(val);
            return;
        }

        while (lastNode.next != null)
            lastNode = lastNode.next;

        lastNode.next = new Node(val);
        return;
    }

    public void printList() {
        for(Node iter=this.head; iter != null; iter=iter.next)
            System.out.print(iter.data + " ");
        
        System.out.println("");
        
    }

    public void insertNodes(int num){
        Random rand = new Random();

        for(int i=0; i<num; i++)
            this.appendToTail(rand.nextInt(10));
    }

    public static void main(String args[]){
        // LinkedList myList = new LinkedList(new Node(7));
        LinkedList myList = new LinkedList();
        myList.appendToTail(6);
        myList.appendToTail(4);
        myList.appendToTail(2);
        myList.appendToTail(1);
        myList.printList();

    }
}
