package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingpathInMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 }
				/*
				 * {3,4,5}, {3,2,6}, {2,2,1}
				 */
		};
		System.out.println(longestIncreasingPath(matrix));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if(matrix.length==0) {
			return 0;
		}
		List<List<Integer>> globalSubsequences = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		int[][] memo = new int[matrix.length][matrix[0].length];
		initializeMemo(memo);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfsVisit(i, j, temp, globalSubsequences, memo, matrix, 1);
			}
		}
		/*
		 * for (List<Integer> path : globalSubsequences) {
		 * System.out.println(Arrays.toString(path.toArray())); }
		 */
		/*
		 * System.out.println("Memo array values"); for (int[] vals : memo) {
		 * System.out.println(Arrays.toString(vals)); }
		 */
		int max = 0;
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				if(memo[i][j]>max) {
					max=memo[i][j];
				}
			}
		}
		return max;
	}

	private static int dfsVisit(int i, int j, List<Integer> temp, List<List<Integer>> globalSubsequences, int[][] memo,
			int[][] grid, int level) {
		if (memo[i][j] != -1) {
			return memo[i][j] + level - 1;
		}
		temp.add(grid[i][j]);
		List<int[]> immediatePossiblePathList = fetchPathList(grid, i, j);
		boolean isNotEndOfPath = false;
		int depth = 0;
		for (int[] immediatePath : immediatePossiblePathList) {
			isNotEndOfPath = true;
			int pathLength = dfsVisit(immediatePath[0], immediatePath[1], temp, globalSubsequences, memo, grid,
					level + 1);

			if (pathLength > depth) {
				depth = pathLength;
			}
		}
		if (!isNotEndOfPath) {
			globalSubsequences.add(new ArrayList<Integer>(temp));
		}

		temp.remove(temp.size() - 1);

		if (depth == 0) {
			memo[i][j] = 1;
			return level;
		} else {
			memo[i][j] = depth - level + 1;
			return depth;
		}
		/*
		 * if (level > depth) { memo[i][j]=1; return level; } else { memo[i][j] =
		 * depth-level+1; return depth; }
		 */

	}

	private static List<int[]> fetchPathList(int[][] grid, int i, int j) {
		int noOFRows = grid.length;
		int noOFCols = grid[0].length;
		List<int[]> allowedPathList = new ArrayList<int[]>();
		if (i - 1 >= 0 && grid[i - 1][j] > grid[i][j]) {
			allowedPathList.add(new int[] { i - 1, j });
		}
		if (j - 1 >= 0 && grid[i][j - 1] > grid[i][j]) {
			allowedPathList.add(new int[] { i, j - 1 });
		}
		if (i + 1 < noOFRows && grid[i + 1][j] > grid[i][j]) {
			allowedPathList.add(new int[] { i + 1, j });
		}
		if (j + 1 < noOFCols && grid[i][j + 1] > grid[i][j]) {
			allowedPathList.add(new int[] { i, j + 1 });
		}
		return allowedPathList;
	}

	private static void initializeMemo(int[][] memo) {
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = -1;
			}
		}
	}
}
