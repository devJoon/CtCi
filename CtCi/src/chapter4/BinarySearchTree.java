package chapter4;

import java.util.HashSet;
import java.util.Random;

public class BinarySearchTree {
	public static class Node {
		Node parent;
		int value;
		Node left;
		Node right;
		
		public Node(int val) {
			parent = null;
			value = val;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int height;

	public Node getRoot() { return root; }
	public int getHeight() {
		return height;
	}

	public BinarySearchTree() {
		root = null;
		height = 0;
	}
	
	public Node getRandomNode(Node n) {
		
		if (n==null)
			return null;
		else {
			Random rnd = new Random();
			if (rnd.nextInt(4) == 0) {
				return n;
			}
			else if (n.left == null && n.right == null) {
				return n;
			}
			else {
				Node t = (n.left == null)?n.right:n.left;
				return getRandomNode(t);
			}
		}		
	}
	
	public Node getRandomNode2(Node n) {
		
		if (n==null)
			return null;
		
		Node tmp = n;
		while (tmp.left != null || tmp.right != null ) {
			
			Random rnd = new Random();
			int rndInt = rnd.nextInt(5);
			System.out.println("rndInt : " + rndInt);
					
			if (rndInt == 0)		
				break;
			else if (rndInt == 1 && tmp.left != null) {
				tmp = tmp.left;
			}
			else if (rndInt == 2 && tmp.right != null) {
				tmp = tmp.right;
			}
		}
		
		return tmp;		
	}
		
	public Node insert(int n) {
		
		Node node = new Node(n);
		
		System.out.print(n + " ");

		if (root == null) {
			root = new Node(n);
			height = 1;
		}
		else {			
			Node cur = root;
			int h = 1;
			while(true) {
				h++;
				if (n < cur.value) {
					// insert to left
					if (cur.left == null) {
						cur.left = node;
						cur.left.parent = cur;
						break;
					}

					cur = cur.left;
				}
				else {
					// insert to right
					if (cur.right == null) {
						cur.right = node;
						cur.right.parent = cur;
						break;
					}

					cur = cur.right;
				}
			}
			if (h > height)
				height = h;
		}
		
		/*System.out.println("inserted value " + n);
		System.out.println("height : " + height);*/

		return node;
	}
	
	public void print(Node n) {
		System.out.println(n.value);
		if (n.left != null)
			print(n.left);
		if (n.right != null)
			print(n.right);
		return;
	}

	// build binary search tree without duplicate node value.
	public void build(int n, int bound) {
		Random rand = new Random();
		
		this.root = null; // clear tree
		
		if (n > bound) {
			return;
		}
		
		HashSet<Integer> pick = new HashSet<>();
		
		for(int chosen = 0; chosen<=n;) {
			int num = rand.nextInt(bound);
			if (!pick.contains(num)) {
				insert(num);
				pick.add(num);
				chosen++;
			}			
		}
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		/*bst.insert(new Node(8));
		bst.insert(new Node(3));
		bst.insert(new Node(1));
		bst.insert(new Node(5));
		bst.insert(new Node(15));
		bst.insert(new Node(11));
		bst.insert(new Node(17));*/
		
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		bst.insert(15);
		bst.insert(11);
		bst.insert(17);		
				
		bst.print(bst.root);
	}
}
