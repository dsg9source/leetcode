package UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LargestComponentSizeByCommonFactor {
	public static void main(String[] args) {
		int[] A=new int[] {4,6,15,35};
		System.out.println(largestComponentSize(A));
	}

	public static int largestComponentSize(int[] A) {
		int max=0;
		for(int i=0;i<A.length;i++) {
			if(A[i]>max) {
				max=A[i];
			}
		}
		int[] parent=new int[max+1];
		makeSet(parent);
		for(int i=0;i<A.length;i++) {
			for(int j=2;j<=Math.sqrt(A[i]);j++) {
				if(A[i]%j==0) {
					union(A[i],j,parent);
					union(A[i],A[i]/j,parent);
				}
			}
		}

		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++) {
			int par=find(A[i],parent);
			if(!map.containsKey(par)) {
				map.put(par, 1);
			}else {
				map.put(par, map.get(par)+1);
			}
		}
		int maxValue=0;
		for(Entry<Integer,Integer> entry:map.entrySet()) {
			if(entry.getValue()>maxValue) {
				maxValue=entry.getValue();
			}
		}
		return maxValue;
		
		
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
