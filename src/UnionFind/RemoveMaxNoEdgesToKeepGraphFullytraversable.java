package UnionFind;

public class RemoveMaxNoEdgesToKeepGraphFullytraversable {
	public static void main(String[] args) {
		int[][] edges = new int[][] {
				 {3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4} 

				/* {3,1,2}, {3,3,4}, {1,1,3},{2,2,4} */
/*				{ 3, 1, 2 }, { 2, 2, 3 }, { 3, 1, 4 }, { 2, 3, 5 }, { 1, 2, 6 }, { 2, 4, 7 }, { 3, 3, 8 }, { 3, 2, 9 },
				{ 2, 1, 10 }, { 2, 1, 11 }, { 1, 11, 12 }, { 1, 10, 11 }, { 2, 5, 9 }, { 2, 7, 10 }, { 2, 4, 12 },
				{ 3, 9, 10 }, { 1, 6, 9 }, { 2, 10, 12 }, { 1, 2, 5 }, { 3, 5, 6 }, { 1, 7, 11 }, { 1, 8, 9 },
				{ 1, 1, 11 }, { 3, 4, 5 }, { 1, 5, 9 }, { 2, 4, 9 }, { 1, 8, 11 }, { 3, 6, 8 }, { 1, 8, 10 },
				{ 2, 2, 4 }, { 2, 3, 8 }, { 3, 2, 6 }, { 3, 10, 11 }, { 2, 3, 11 }, { 3, 5, 9 }, { 3, 3, 5 },
				{ 2, 6, 11 }, { 3, 2, 7 }, { 1, 5, 11 }, { 1, 1, 5 }, { 2, 9, 10 }, { 1, 6, 7 }, { 3, 2, 3 },
				{ 2, 8, 9 }, { 3, 2, 8 }*/

		};
		System.out.println(maxNumEdgesToRemove(4, edges));
	}

	public static int maxNumEdgesToRemove(int n, int[][] edges) {
		if (edges == null || edges.length == 0)
			return -1;
		int[] parentAlice = new int[n + 1];
		int[] parentBob = new int[n + 1];

		int count = 0;
		makeSet(parentAlice);
		makeSet(parentBob);

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (edge[0] == 3) {
				boolean isAlreadyConnectedAlice = isRedundant(edge[1], edge[2], parentAlice);
				boolean isAlreadyConnectedBob = isRedundant(edge[1], edge[2], parentBob);
				if (isAlreadyConnectedAlice || isAlreadyConnectedBob) {
					count++;
				}

			}
		}

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (edge[0] == 1) {
				boolean isAlreadyConnected = isRedundant(edge[1], edge[2], parentAlice);
				if (isAlreadyConnected) {
					count++;
				}
			}
			if (edge[0] == 2) {
				boolean isAlreadyConnected = isRedundant(edge[1], edge[2], parentBob);
				if (isAlreadyConnected) {
					count++;
				}

			}
		}
		// traverse both the parent arrays to chk if all the vertices can be reached by
		// each of them
		int edgesInAlice = 0;
		int edgesInBob = 0;

		for (int i = 0; i < parentAlice.length; i++) {
			// System.out.println(Math.abs(parentAlice[i])+" **");
			if (parentAlice[i] >= 0) {
				edgesInAlice++;
			}
		}
		for (int i = 0; i < parentBob.length; i++) {
			if (parentBob[i] >= 0) {
				edgesInBob++;
			}
		}

		if ((edgesInAlice != n - 1) || (edgesInBob != n - 1)) {
			return -1;
		}

		return count;
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

	public static boolean isRedundant(int x, int y, int[] parent) {
		// returns -1 if Redundant edge
		// 0 if not

		int p1 = find(x, parent);
		int p2 = find(y, parent);
		if (p1 == p2) {
			// already belognds to same set i.e. coming edge is redundant edge
			return true;
		} else {
			if (p1 <= p2) {
				parent[p1] = parent[p1] + parent[p2];
				parent[p2] = p1;
			} else {
				parent[p2] = parent[p2] + parent[p1];
				parent[p1] = p2;
			}
		}
		return false;
	}
}
