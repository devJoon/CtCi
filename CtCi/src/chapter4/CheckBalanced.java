package chapter4;

import chapter4.BinarySearchTree.Node;

public class CheckBalanced {
	private BinarySearchTree bst;
	
	public CheckBalanced() {
		bst = new BinarySearchTree();
	}
	
	/* Calculate maximum height of a tree starting from the node n.*/
	private int calcHeight(Node n) {
		if (n==null)
			return 0;
		else
			return 1 + Math.max(calcHeight(n.left), calcHeight(n.right));
	}
	
	/* Test if tree starting from the node n is balanced. 
	 * Empty tree is considered balanced. 
	 */
	public Boolean isBalanced(Node n) {
		if (n == null)
			return true;
		else {
			if ( Math.abs(calcHeight(n.left) - calcHeight(n.right)) > 1)
				return false;
			else
				return isBalanced(n.left) && isBalanced(n.right);
		}
	}
	
	public static void main(String[] args) {
		CheckBalanced cb = new CheckBalanced();
		
        /* used MinimalTree class to build complete binary tree. */
        MinimalTree mt = new MinimalTree();
        mt.fill(10);
        mt.buildTree(0, 9);

        cb.bst = mt.getBst();				
		System.out.println(cb.isBalanced(cb.bst.getRoot()));
		cb.bst.build(10, 30);
		System.out.println(cb.isBalanced(cb.bst.getRoot()));
	}	
}
