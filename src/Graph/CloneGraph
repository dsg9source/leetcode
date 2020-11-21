package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	public static void main(String[] args) {

	}

	public Node cloneGraph(Node node) {
	//	Node[] isVisited=new Node[101];
		Map<Integer,Node> isVisited=new HashMap<Integer,Node>();
		if(node==null) {
			return null;
		}
		return visitNodeAndReturnClone(node,isVisited);
	}

	private Node visitNodeAndReturnClone(Node node, Map<Integer,Node> isVisited) {
		isVisited.put(node.val,new Node(node.val));
		if(node.neighbors.size()!=0) {
			ArrayList<Node> neighbours=new ArrayList<Node>();
			for(Node neighbour:node.neighbors) {
				if(isVisited.get(neighbour.val)==null) {
					neighbours.add(visitNodeAndReturnClone(neighbour, isVisited));
				}else {
					neighbours.add(isVisited.get(neighbour.val));
				}
				
			}
			
			Node myClone=isVisited.get(node.val);
			myClone.neighbors=neighbours;
			
			return myClone;
		} else {
			Node myClone=isVisited.get(node.val);
			myClone.neighbors=new ArrayList<Node>();
			return myClone;
		}
		
	}
}
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
