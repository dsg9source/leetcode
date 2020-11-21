package Graph;

import java.util.Arrays;

public class CountServersThatCommunicate {
	// https://leetcode.com/problems/count-servers-that-communicate/

	public static void main(String[] args) {
		int[][] grid = {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
;
		System.out.println(countServers(grid));
	}

	public static int countServers(int[][] grid) {

		int noOfRows = grid.length;
		int noOfCols = grid[0].length;
		int[] rowServerCount = new int[noOfRows];
		int[] colServerCount = new int[noOfCols];
		int totalServerCount = 0;
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if (grid[i][j] == 1) {
					rowServerCount[i] = rowServerCount[i] + 1;
					colServerCount[j] = colServerCount[j] + 1;
				}

			}

		}

		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if (grid[i][j] == 1) {
					if (rowServerCount[i] > 1 || colServerCount[j] > 1) {
						totalServerCount++;
					}
				}
			}
		}
		return totalServerCount;

	}
}
