package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class PathWithMinimumEffort {
	public static void main(String args[]) {
		int[][] input=new int[][]{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
		System.out.println(minimumEffortPath(input));
	}

	public static int minimumEffortPath(int[][] heights) {
		if(heights.length==0) {
			return 0;
		}
		boolean[] recStack=new boolean[heights[0].length*heights.length];
		List<Integer> listOfAllPaths=new ArrayList<Integer>();
		dfsVisit(0, 0, heights.length-1, heights[0].length-1, recStack, heights, heights[0][0], 0, listOfAllPaths);
		int minEffort=Integer.MAX_VALUE;
		for(Integer effort:listOfAllPaths) {
			if(minEffort>effort) {
				minEffort=effort;
			}
		}
		return minEffort;
	}

	public static List<Integer[]> adjacent(int i, int j, int[][] grid) {
		List<Integer[]> adjacent=new ArrayList<Integer[]>();
		if (i + 1 < grid.length) {
			adjacent.add(new Integer[] {i+1,j});
		}
		if (i - 1 >= 0) {
			adjacent.add(new Integer[] {i-1,j});
		}
		if (j + 1 < grid[0].length) {
			adjacent.add(new Integer[] {i,j+1});
		}
		if (j - 1 >= 0) {
			adjacent.add(new Integer[] {i,j-1});
		}
		
		return adjacent;
	}
	
	public static void dfsVisit(int i ,int j,int targeti,int targetj,boolean[] recStack,int[][]grid,int lastHeight,int maxValue,List<Integer> listOFAllEfforts) {
		if(recStack[i*grid[0].length+j]) {
			return;
		}
		recStack[i*grid[0].length+j]=true;
		if(i==targeti && j==targetj) {
			if(Math.abs(lastHeight-grid[i][j])>maxValue) {
				listOFAllEfforts.add(Math.abs(lastHeight-grid[i][j]));
			}else {
				listOFAllEfforts.add(maxValue);
			}
			recStack[i*grid[0].length+j]=false;
			return;
			
		}else {
			if(Math.abs(lastHeight-grid[i][j])>maxValue) {
				maxValue=Math.abs(lastHeight-grid[i][j]);
			}
			for(Integer[] edge:adjacent(i, j, grid)) {
				dfsVisit(edge[0],edge[1],targeti,targetj,recStack,grid,grid[i][j],maxValue,listOFAllEfforts);
			}
			recStack[i*grid[0].length+j]=false;
			return;
			
		}
		
	}
}
