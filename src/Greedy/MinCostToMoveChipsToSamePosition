package Greedy;

public class MinCostToMoveChipsToSamePosition {
	public static void main(String args[]) {
		// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
		int[] A = new int[] { 2, 2, 2, 3, 3 };
		System.out.println(minCostToMoveChips(A));
	}

	public static int minCostToMoveChips(
			int[] position) {/*
								 * int minCost=Integer.MAX_VALUE; int localCost=0; for(int
								 * i=0;i<position.length-1;i++) { for(int j=position.length-1;j>=0;j--) {
								 * if((position[j]-position[i])%2==0) { localCost=localCost+0; }else {
								 * localCost=localCost+1; } } if(minCost>localCost) { minCost=localCost;
								 * 
								 * } localCost=0; } return minCost;
								 */
		// Easy approach
		int countEven = 0;
		int countOdd = 0;
		for (int i = 0; i < position[i]; i++) {

			if (position[i] % 2 == 0) {
				countEven++;
			} else {
				countOdd++;
			}

		}
		if (countEven > countOdd) {
			return countOdd;
		} else {
			return countEven;
		}

	}
}
