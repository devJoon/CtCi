package chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree {
	public static class Node {
		Node parent;
		int value;
		Node left;
		Node right;
		
		public Node(int val) {
			value = val;
		}

	}
	
	private Node root;
	private int height;
	private int nodeNo;

	public Node getRoot() { return root; }
	public int getHeight() {
		return height;
	}
	public int getNodeNo() { return nodeNo; }

	public BinarySearchTree() {
		root = null;
		height = 0;
	}

	/* Not completely random, just used for tests. */
	public Node getPseudoRandomNode() {
		
		if (getRoot()==null)
			return null;
		
		Node tmp = getRoot();
		while (tmp.left != null || tmp.right != null ) {
			
			Random rnd = new Random();
			int rndInt = rnd.nextInt(5);
			// System.out.println("rndInt : " + rndInt);
					
			if (rndInt == 0)		
				break;
			else if (rndInt < 3 && tmp.left != null) {
				tmp = tmp.left;
			}
			else if (rndInt < 5 && tmp.right != null) {
				tmp = tmp.right;
			}
		}
		
		return tmp;		
	}

	/* Possibly return a random node from the tree.  */
	public Node getRandomNode() {

		if (getRoot() == null)
			return null;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(getRoot());
		int denom = getNodeNo();
		Random rng = new Random();

		while(!queue.isEmpty()) {
			Node n = queue.poll();
			// picked
			if (rng.nextInt(denom--) == 0) {
				// System.out.println("Picked node with value " + n.value);
				return n;
			}

			if (n.left != null)
				queue.offer(n.left);
			if (n.right != null)
				queue.offer(n.right);
		}

		System.out.println("Something is WRONG!! ");
		return null;
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

		nodeNo++;
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
		
		for(int chosen = 0; chosen<n;) {
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
