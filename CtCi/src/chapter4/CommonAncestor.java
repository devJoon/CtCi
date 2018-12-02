package chapter4;

import java.util.ArrayList;

import chapter4.BinarySearchTree.Node;

public class CommonAncestor {

	private static Boolean covers(Node r, Node n) {
		if (r == null || n == null)
			return false;

		if (r == n)
			return true;
		else
			return covers(r.left, n) || covers(r.right, n);
	}

	/* problem : covers func repeatedly searches same node. */
	public static Node getCommonAncestor(Node root, Node p, Node q) {

		// when either of nodes are not covered by the tree starting from the root.
		if (covers(root, p) == false || covers(root, q) == false )
			return null;

		if (root == null || root == p || root == q)
			return root;

		boolean isNodepOnLeft = covers(root.left, p);
		boolean isNodeqOnLeft = covers(root.left, q);

		// when two of nodes are on different side, root is the first common ancestor.
		if (isNodepOnLeft != isNodeqOnLeft)
			return root;

		// search for the sub-tree having both p, q as a node.
		Node searchRoot = isNodepOnLeft ? root.left : root.right;
		return getCommonAncestor(searchRoot, p, q);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		
		bst.build(20, 40);
		System.out.println();

		Node a = bst.getPseudoRandomNode();
		Node b = bst.getPseudoRandomNode();
						
		System.out.println("first node to find : " + a.value);
		System.out.println("second node to find : " + b.value);
				
		Node r = CommonAncestor.getCommonAncestor(bst.getRoot(), a, b);
		System.out.println("common ancestor : " + r.value);
	}
}
