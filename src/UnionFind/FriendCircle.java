package UnionFind;

public class FriendCircle {
	// https://leetcode.com/problems/friend-circles/
	public static void main(String[] args) {

	}

	public int findCircleNum(int[][] M) {
		int[] parent = new int[M.length]; // since M is a n*n matrix
		makeSet(parent.length, parent);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if(i!=j && M[i][j]==1) {
					union(i, j, parent);
				}
			}
		}
		int count=0;
		for(int i=0;i<parent.length;i++) {
			if(parent[i]<0) {
				count++;
			}
		}
		return count;

	}

	public void makeSet(int size, int[] parent) {
		for (int i = 0; i < size; i++) {
			parent[i] = -1;
		}
	}

	public int find(int x, int[] parent) {
		if (x >= 0 && x < parent.length) {
			if (parent[x] < 0) {
				// this is a true parent
				return x;
			} else {
				return find(parent[x], parent);
			}
		} else {
			return -1; // elemnt not found
		}
	}

	public void union(int r1, int r2, int[] parent) {
		int p1 = find(r1, parent);
		int p2 = find(r2, parent);
		if (p1 == p2) {
			return;
		} else {
			if (p1 <= p2) {
				parent[p1] = parent[p1] + parent[p2];
				parent[p2] = p1;
			}else{
                parent[p2] = parent[p2] + parent[p1];
				parent[p1] = p2;
            }
		}
		

	}
}
