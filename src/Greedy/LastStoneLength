package Greedy;

import java.util.Arrays;

public class LastStoneLength {
	public static void main(String[] args) {

	}

	public int lastStoneWeight(int[] stones) {
        
		Arrays.sort(stones);
		int x,y;
		int newStone,j;
		for (int i = stones.length - 1; i > 0; i--) {
			y=stones[i];
			x=stones[i-1];
			newStone=y-x;
			j=i-1;
			while(j>0 && stones[j-1]>newStone ) {
				stones[j]=stones[j-1];
				j--;
			}
			if(j==0) {
				stones[j]=newStone;
			}
			else if(stones[j-1]<=newStone) {
				stones[j]=newStone;
			}
		}
		return stones[0];
	
    }
}
