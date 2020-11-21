package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphConnectivityWithThreshhold {
	public static void main(String[] args) {
		int[][] queries=new int[][] {{4,5},{3,4},{3,2},{2,6},{1,3}};
		System.out.println(Arrays.toString(areConnected(6,1,queries).toArray()));
	}

	public static List<Boolean> areConnected(int n, int threshold, int[][] queries) {
		int[] parent=new int[n+1];
		List<Boolean> output=new ArrayList<Boolean>();
		makeSet(parent);
		for(int i=threshold+1;i<=n;i++) {
			int count=1;
			while(i*count<=n) {
				union(i,i*count,parent);
				count++;
			}
		}
		for(int[] query:queries) {
			int p1=find(query[0],parent);
			int p2=find(query[1],parent);
			if(p1==p2) {
				output.add(true);
			}else {
				output.add(false);
			}
		}
		return output;
		
		
		
	}
	public static void makeSet(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
	}
	public static int find(int x, int[] parent) {
		// returns node number which is parent
		// with path compression
		if (x >= 0 && x < parent.length) {
			if (parent[x] < 0) {
				return x;
			} else {
				parent[x] = find(parent[x], parent);
				return parent[x];
			}
		} else {
			return -1;
		}
	}
	public static void union(int x, int y, int[] parent) {
		// returns -1 if Redundant edge
		// 0 if not

		int p1 = find(x, parent);
		int p2 = find(y, parent);
		if (p1 == p2) {
			return;
		} else {
			if (p1 <= p2) {
				parent[p1] = parent[p1] + parent[p2];
				parent[p2] = p1;
			} else {
				parent[p2] = parent[p2] + parent[p1];
				parent[p1] = p2;
			}
		}
		return;
	}
}
