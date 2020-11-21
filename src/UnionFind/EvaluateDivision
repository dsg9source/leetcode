package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {
	public static void main(String[] args) {
		
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<Node>> map = new HashMap<String, List<Node>>();
		int counter = 0;
		double[] output=new double[queries.size()];
		for (List<String> vars : equations) {
			if (map.containsKey(vars.get(0))) {
				map.get(vars.get(0)).add(new Node(vars.get(1), values[counter]));
			} else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(vars.get(1), values[counter]));
				list.add(new Node(vars.get(0),1.00));
				map.put(vars.get(0), list);

			}
			// add entry for destination node as well
			if (map.containsKey(vars.get(1))) {
				map.get(vars.get(1)).add(new Node(vars.get(0), 1 / values[counter]));
			} else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(vars.get(0), 1 / values[counter]));
				list.add(new Node(vars.get(1),1.00));
				map.put(vars.get(1), list);

			}
			counter++;
		}
		int queryCounter=0;
		for (List<String> query : queries) {
			Queue<Node> q = new LinkedList<Node>();
			Set<String> visited = new HashSet<String>();
			String start = query.get(0);
			String end = query.get(1);
			List<Node> neightbours = map.get(start);
			if(neightbours!=null && neightbours.size()>0) {
				for (Node n : neightbours) {
					n.totalCost=n.value;
					q.offer(n);
				}
			}else if(neightbours==null){
				output[queryCounter]=-1;
			}

			visited.add(start);
			while (!q.isEmpty()) {
				Node temp = q.poll();
				visited.add(temp.name);
				if(temp.name.equals(end)) {
					output[queryCounter]=temp.totalCost;
					break;
				}
				List<Node> neighbours = map.get(temp.name);
				if(neighbours!=null && neighbours.size()>0) {
					for (Node neighbour : neighbours) {
						neighbour.totalCost=neighbour.value*temp.totalCost;
						if(!visited.contains(neighbour.name)) {
							q.offer(neighbour);
						}
					}
				}

			}
			if(!visited.contains(end)) {
				output[queryCounter]=-1.00;
			}
			queryCounter++;

		}
		return output;

	}

}

class Node {
	Node(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	String name;
	Double value;
	Double totalCost;
}
