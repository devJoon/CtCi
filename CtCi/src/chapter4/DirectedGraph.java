package chapter4;

import chapter3.MyQueue;

import java.util.ArrayList;
import java.util.Random;

public class DirectedGraph {
	
	private class Node {
		int data;
		ArrayList<Node> children;
		Boolean visited;
		
		private Node(int data) {
			this.data = data;
			children = new ArrayList<>();
			visited = false;
		}

		/* Connect two nodes in a graph.
		 * TODO : Need to check duplicate node (Omitted for simplicity)
		 */
		private Boolean connect(Node node) {
			return children.add(node);
		}

		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	private ArrayList<Node> nodes;
	
	/* Add a node into graph. */
	public Boolean add(Node node) {						
		return nodes.add(node);
	}
	
	public DirectedGraph() {
		nodes = new ArrayList<Node>();
	}
	
	public DirectedGraph(int n) {
		
		nodes = new ArrayList<Node>();
		for(int i=0; i<n; i++) {
			nodes.add(new Node(i));
		}
				
		for(int i=0; i<n; i++) {
			Random random = new Random();
			int j;
			do {
				j = random.nextInt(n);
			} while (j == i );
			
			nodes.get(i).connect(nodes.get(j));
		}

	}

	public void print() {
		for(Node n: nodes){
			System.out.print(n.data + " : ");
			for(Node c: n.children) {
				System.out.print(c.data + " ");
			}
			System.out.println();
		}
	}

	/* Determine whether there is a route from node A to node B.
	 * Implemented to use Breadth-First Search using queue.
	 */
	public Boolean search(Node nodeA, Node nodeB) {

		MyQueue<Node> queue = new MyQueue<>();
		nodeA.visited = true;
		queue.add(nodeA);

		while(!queue.isEmpty()){
			Node r = queue.remove();
			if (r == nodeB)
				return true;
			for(Node n : r.children) {
				if (n.visited == false) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
		return false;
	}
		
	public static void main(String[] args) {
		
		DirectedGraph dg = new DirectedGraph(10);
		dg.print();
		System.out.println(dg.search(dg.nodes.get(0), dg.nodes.get(9)));

	}
}
