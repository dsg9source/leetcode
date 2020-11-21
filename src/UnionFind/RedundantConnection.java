package UnionFind;

import java.util.Stack;

public class RedundantConnection {
	public static void main(String args[]) {
	}

	public int[] findRedundantConnection(int[][] edges) {
		int[] parent=new int[edges.length+1]; //check for indexing
		for(int i=0;i<parent.length;i++) {
			parent[i]=-1;
		}
		Stack<int[]> stack=new Stack<int[]>();
		for(int[] edge:edges) {
			int p1=find(edge[0],parent);
			int p2=find(edge[1],parent);
			if(p1==p2) {
				stack.push(edge);
			}else {
				union(p1,p2,parent);
			}
		}
		return stack.pop();
	}

	private void union(int p1, int p2, int[] parent) {
		if(p1==p2) {
			return;
		}else {
			if(parent[p1]<parent[p2]) {
				parent[p1]=parent[p1]+parent[p2];
				parent[p2]=p1;
			}else {
				parent[p2]=parent[p2]+parent[p1];
				parent[p1]=p2;
			}
		}
		
	}

	private int find(int i,int[] parent) {
		if(parent[i]<0) {
			return i;
		}else {
			return find(parent[i],parent);
		}

	}
}
