package chapter4;

import java.util.ArrayList;
import java.util.Random;

public class DirectedGraph {
	
	private class Node {
		int data;
		ArrayList<Node> children;
		
		private Node(int data) {
			this.data = data;
			children = new ArrayList<>();
		}
		
		private Node() {
			children = new ArrayList<>();
		}
		
		/* Connect two nodes in a graph.
		 * TODO : Need to check duplicate node 
		 */
		private Boolean connect(Node node) {
			return children.add(node);
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
	
	/* Determine whether there is a route from node A to node B. */
	public Boolean isConnected(Node nodeA, Node nodeB) {
		
		return true;
	}
		
	public static void main(String[] args) {
		
		DirectedGraph dg = new DirectedGraph(10);
		
	}
	
}
