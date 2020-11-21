package Greedy;

import java.util.Arrays;

public class MaximizeArraySumAfterKNegation {
	public static void main(String[] args) {
		//https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/submissions/
	}

	public int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);
		int largestNegativeIndex=-1;
		for (int i = 0; i < A.length && K > 0; i++) {
			if (A[i] < 0) {
				A[i] = -A[i];
				K--;
				largestNegativeIndex=i;
				continue;
			}
			if (A[i] >= 0) {
				if (K % 2 == 0) {
					K = 0;
				} else {
					if(largestNegativeIndex>=0 && A[largestNegativeIndex]<A[i]) {
						A[largestNegativeIndex] = -A[largestNegativeIndex];
					}else {
						A[i] = -A[i];
					}
					
					K = 0;

				}
			}
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		return sum;

	}
}
