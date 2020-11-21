package Graph;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfVerticesToReachAllNodes {
	public static void main(String[] args) {

	}

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] verticesInDegree=new boolean[n];
		for(List<Integer> edge:edges) {
			verticesInDegree[edge.get(1)]=true;
		}
		List<Integer> setOfInitialVertices=new ArrayList<Integer>();
		for(int i=0;i<verticesInDegree.length;i++) {
			if(verticesInDegree[i]==false) {
				setOfInitialVertices.add(i);
			}
		}
		return setOfInitialVertices;
		
	}
}
