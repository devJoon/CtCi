package chapter4;

import java.util.Random;

public class BinarySearchTree {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int val) {
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
	
	public void insert(Node n) {
		
		if (root == null) {
			root = n;
			height = 1;
		}
		else {
			Node cur = root;
			int h = 1;
			while(true) {
				h++;
				if (n.value < cur.value) {
					// insert to left
					if (cur.left == null) {
						cur.left = n;
						break;
					}
					
					cur = cur.left;
				}
				else {
					// insert to right
					if (cur.right == null) {
						cur.right = n;
						break;
					}
					
					cur = cur.right;
				}
			}
			
			if (h > height)
				height = h;
		}
		
		System.out.println("height : " + height);
		
				
		return;
		
		/*if (root == null)
			System.out.println("root is null");
		
		Node cur;
		for(cur = root; cur != null; cur = (n.value < cur.value) ? cur.left : cur.right);
		cur = n;
		return;*/
	}
	
	public void insert(int n) {

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
						cur.left = new Node(n);
						break;
					}

					cur = cur.left;
				}
				else {
					// insert to right
					if (cur.right == null) {
						cur.right = new Node(n);
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

		return;
	}
	
	public void print(Node n) {
		System.out.println(n.value);
		if (n.left != null)
			print(n.left);
		if (n.right != null)
			print(n.right);
		return;
	}

	public void build(int n, int bound) {
		Random rand = new Random();
		
		this.root = null; // clear tree

		for(int i=0; i<n; i++) {
			insert(rand.nextInt(bound));
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
