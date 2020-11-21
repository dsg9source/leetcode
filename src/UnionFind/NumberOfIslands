package UnionFind;

public class NumberOfIslands {
	public static void main(String args[]) {
		char[][] input = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(input));
	}

	public static int numIslands(char[][] grid) {
		// m*n grid.
		int noOfCols = grid[0].length;
		int noOfRows = grid.length;

		if (grid.length == 0) {
			return 0;
		}

		int[] parent = new int[noOfRows * noOfCols];
		// makeSet(parent);
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if (grid[i][j] == '1') {
					parent[noOfCols * i + j] = -1;
					if (i - 1 >= 0) {
						if (grid[i - 1][j] == '1') {
							union(noOfCols * (i - 1) + j, noOfCols * (i) + j, parent);
						}
					}
					if (j - 1 >= 0) {
						if (grid[i][j - 1] == '1') {
							union(noOfCols * i + j - 1, noOfCols * i + j, parent);
						}
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] < 0) {
				count++;
			}
		}
		return count;
	}



	public static int find(int x, int[] parent) {
		if (parent[x] < 0) {
			return x;
		} else {
			return find(parent[x], parent);
		}
	}

	public static void union(int r1, int r2, int[] parent) {
		int p1 = find(r1, parent);
		int p2 = find(r2, parent);
		if(p1==p2) {
			return;
		}
		if (parent[p1] <= parent[p2]) {
			parent[p1] = parent[p1] + parent[p2];
			parent[p2] = p1;
		} else {
			parent[p2] = parent[p2] + parent[p1];
			parent[p1] = p2;
		}
	}
}
