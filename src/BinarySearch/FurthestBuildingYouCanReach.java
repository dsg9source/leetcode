package BinarySearch;

public class FurthestBuildingYouCanReach {
	public static void main(String[] args) {
		int[] heights=new int[] {12,13,14,10,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6,7,8,9,8,7,6,5,54,34,3,4,5,6,7564,43,578,467,35,67};
		System.out.println(furthestBuilding(heights,40, 50));
	}

	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		return dfs(1,heights,bricks,ladders);
	}

	private static int dfs(int index, int[] heights, int bricks, int ladders) {
		System.out.println(index);
		if(index>=heights.length) {
			return heights.length-1;
		}else {
			if(heights[index]<=heights[index-1]) {
				return dfs(index+1,heights,bricks,ladders);
			}else {
				if(ladders<=0 && bricks-(heights[index]-heights[index-1])<0) {
					return index-1;
				}
				int useBrick=0;
				int useLadder=0;
				if(bricks-(heights[index]-heights[index-1])>=0){
					useBrick=dfs(index+1,heights,bricks-(heights[index]-heights[index-1]),ladders);
				}
				if(ladders-1>=0) {
					useLadder=dfs(index+1,heights,bricks,ladders-1);
				}
				
				if(useBrick>useLadder) {
					return useBrick;
				}else {
					return useLadder;
				}
			}
		}
	}
}
