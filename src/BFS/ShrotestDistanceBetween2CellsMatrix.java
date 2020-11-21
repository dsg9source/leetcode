package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShrotestDistanceBetween2CellsMatrix {
	public static void main(String[] args) {
		char[][] input = new char[][] { { '0', '*', '0', 's' }, { '*', '0', '*', '*' }, { '0', '*', '*', '*' },
				{ 'd', '0', '0', '0' } };
		System.out.println(findShortestDistance(input, new int[] { 0, 3 }));
	}

	public static int findShortestDistance(char[][] grid, int[] start) {
		Queue<int[]> q = new LinkedList<int[]>();
		Set<List<Integer>> nodeTracker = new HashSet<List<Integer>>();
		int level = 0;
		q.offer(start);
		nodeTracker.add(convertFormat(start));
		while (!q.isEmpty()) {
			int count = q.size();
			while (count != 0) {
				int[] pos = q.poll();
				if (grid[pos[0]][pos[1]] == 'd') {
					return level;
				} else {
					List<int[]> adj = discoverUnvisitedAdjacent(pos, nodeTracker, grid);
					for (int[] loc : adj) {
						List<Integer> node = convertFormat(loc);
						if (!nodeTracker.contains(node)) {
							q.offer(loc);
							nodeTracker.add(node);
						}

					}
				}
				count--;
			}
			level++;
		}
		return -1;
	}

	private static List<int[]> discoverUnvisitedAdjacent(int[] pos, Set<List<Integer>> nodeTracker, char[][] grid) {
		int noOfRows = grid.length;
		int noOfCols = grid[0].length;
		List<int[]> list = new ArrayList<int[]>();
		if (pos[0] + 1 < noOfRows && grid[pos[0] + 1][pos[1]] != '0') {
			list.add(new int[] { pos[0] + 1, pos[1] });
		}
		if (pos[0] - 1 >= 0 && grid[pos[0] - 1][pos[1]] != '0') {
			list.add(new int[] { pos[0] - 1, pos[1] });
		}
		if (pos[1] + 1 < noOfCols && grid[pos[0]][pos[1] + 1] != '0') {
			list.add(new int[] { pos[0], pos[1] + 1 });
		}
		if (pos[1] - 1 >= 0 && grid[pos[0]][pos[1] - 1] != '0') {
			list.add(new int[] { pos[0], pos[1] - 1 });
		}
		return list;

	}

	public static List<Integer> convertFormat(int[] pos) {
		List<Integer> retrunList = new ArrayList<Integer>();
		retrunList.add(pos[0]);
		retrunList.add(pos[1]);
		return retrunList;
	}
}
