package chapter4;

import java.util.ArrayList;

import chapter4.BinarySearchTree.Node;

public class CommonAncestor {
	

	public static Node getCommonAncestor(Node startNode, ArrayList<Node> targetNode) {
		
		if (startNode == null)
			return null;
		
		// TODO : case when same two nodes are given as an input(exception?)
		
		if (countNode(startNode, targetNode) != 2) {
			return null;
		} else { // count == 2
			if (countNode(startNode.left, targetNode) == 1 
				&& countNode(startNode.right, targetNode) == 1)
			{
				// System.out.println("ans : " + startNode.value); // found
				return startNode;
			} else if ( targetNode.contains(startNode) && 
					(countNode(startNode.left, targetNode) == 1 || countNode(startNode.right, targetNode) == 1)
					) {
				// System.out.println("ans : " + startNode.value); // found
				return startNode;
			} else {
				Node l = getCommonAncestor(startNode.left, targetNode);
				Node r = getCommonAncestor(startNode.right, targetNode);

				return (l==null)?r:l;
			}
		}
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
		
		/*bst.insert(21);
		bst.insert(32);
		bst.insert(15);
		bst.insert(20);
		bst.insert(8);
		bst.insert(19);
		bst.insert(5);
		bst.insert(36);
		bst.insert(26);
		bst.insert(13);*/
		
		bst.build(10, 20);
		System.out.println();
		
		ArrayList<Node> al = new ArrayList<>();
		
		al.add(bst.getRandomNode2(bst.getRoot()));
		al.add(bst.getRandomNode2(bst.getRoot()));
						
		System.out.println("first node to find : " + al.get(0).value);
		System.out.println("second node to find : " + al.get(1).value);
				
		Node a = CommonAncestor.getCommonAncestor(bst.getRoot(), al);
		System.out.println("common ancestor : " + a.value);
	}
}
