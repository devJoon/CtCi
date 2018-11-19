package chapter4;

import java.util.ArrayList;

import chapter4.BinarySearchTree.Node;

public class CommonAncestor {
	
	
	/* Stuck. */
	public static Node getCommonAncestor(Node startNode, ArrayList<Node> targetNode) {
		
		if (startNode == null)
			return null;
				
		if (countNode(startNode, targetNode) != 2) {
			return null;
		} else { // count == 2
			if (countNode(startNode.left, targetNode) == 1 
				&& countNode(startNode.right, targetNode) == 1)
			{
				System.out.println("ans : " + startNode.value); // found
				return startNode;
			} else {
				
			}
		}
		return startNode;
	}
			
	public static int countNode(Node startNode, ArrayList<Node> targetNode) {
		
		if (startNode == null)
			return 0;
		else {
			return countNode(startNode.left, targetNode) + 
					countNode(startNode.right, targetNode) +
					(targetNode.contains(startNode) ? 1 : 0);
		}
	}
		
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.build(10, 40);
		
		ArrayList<Node> al = new ArrayList<>();
		al.add(bst.getRoot().left);
		al.add(bst.getRoot().right);
		
		int cnt = CommonAncestor.countNode(bst.getRoot(), al);
		System.out.println("\n" + cnt);
	}
}
