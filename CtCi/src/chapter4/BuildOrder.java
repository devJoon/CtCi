package chapter4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BuildOrder {
	
	public class ProjectGraph {
		HashMap<String, ProjectNode> graph;
		
		public ProjectGraph() {
			graph = new HashMap<>();
		}
		
		public Boolean insert(String val) {
			if (!graph.containsKey(val)) {
				// Instantiate node and put it in a graph.
				graph.put(val, new ProjectNode());
				return true;
			} else {
				System.out.println("Node with a value " + val + " is already in the graph.");
				return false;
			}
		}
		
		/* Delete node - must eliminate links connected to other node(s). */
		public Boolean delete(String val) {
			if (!graph.containsKey(val)) {
				System.out.println("Node with a value " + val + " is not in the graph.");
				return false;
			}
			
			Iterator<String> it = graph.get(val).neighbors.iterator();
			while(it.hasNext()){
				//System.out.println(it.next());
				graph.get(it.next()).decInbound();
			}
			graph.remove(val);
			return true;
		}
		
		public void connect(String from, String to) {
			if (!graph.containsKey(from) || !graph.containsKey(to)) {
				System.out.println("Either node is not in graph.");
				return;
			}
			
			ProjectNode fromNode = graph.get(from);
			ProjectNode toNode = graph.get(to);
			
			fromNode.link(to, toNode);			
		}				
	}
	
	
	/* ProjectNode does not contain actual value representation.
	 * It will be presented as a key value of the 'graph' in ProjectGraph class.  
	 */
	public class ProjectNode {
		
		HashSet<String> neighbors;
		int inbound;
		
		public ProjectNode() {
			neighbors = new HashSet<>();
			inbound = 0;
		}
		
		private void link(String val, ProjectNode outNode) {
			
			if (neighbors.contains(val)) {
				return;
			} else {
				neighbors.add(val);
				outNode.incInbound();
			}
		}
		
		private void unlink(String val, ProjectNode outNode) {
			if (!neighbors.contains(val)) {
				return;
			} else {
				neighbors.remove(val);
				outNode.decInbound();
			}
		}
		
		public void incInbound() {
			inbound++;
		}
		
		public void decInbound() {
			inbound--;
		}
	}
				
	public static void main(String[] args) {
		
	}

}
