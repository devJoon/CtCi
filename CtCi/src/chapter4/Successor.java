package chapter4;

import chapter4.BinarySearchTree.Node;

public class Successor {
	
	/* 
	 * Get the in-order successor node of a given node.
	 * Assume that each node has a link to its parent.
	 */
	public static Node getNext(Node node) {		
		Node n;
		// node has right child - go down
		if (node.right != null) {
			for(n=node.right; n.left!=null; n=n.left);
			
			return n;
		} 
		// node doesn't have right child - go up
		else
		{			
			for (n=node; n.parent!=null; n=n.parent) {
				if (n.parent.left == n)
					return n.parent;
			}
			return null;
		}		
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node node;
		bst.insert(25);
		bst.insert(40);
		bst.insert(42); // last node
		bst.insert(27);
		bst.insert(29);
		bst.insert(31);
		bst.insert(32);
		bst.insert(15);
		bst.insert(18);
		bst.insert(17);
		node = bst.insert(16);
		bst.insert(20);
		
		System.out.println();
		System.out.println(Successor.getNext(node).value);				
	}
}
