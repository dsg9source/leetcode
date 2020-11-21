package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
	public static void main(String[] args) {
		int[] weights=new int[] {1,2,3,1,1};
		System.out.println(shipWithinDays(weights,4));
	}

	public static  int shipWithinDays(int[] weights, int D) {
		int maxWeight = 0;
		int sumOFWeights = 0;
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] > maxWeight) {
				maxWeight = weights[i];
			}
			sumOFWeights = sumOFWeights + weights[i];
		}
		if (isPossible(maxWeight, weights, D)) {
			return maxWeight;
		} else {
			int minCapacity = binarySearch(maxWeight, sumOFWeights, weights, D);
			return minCapacity;
		}
		// ship capacity is in between maxWeight and sumofAll weights
		


	}

	private static int binarySearch(int low, int high, int[] weights, int D) {
		if(low==high) {
			return low;
		}
		int mid = (low + high) / 2;
		boolean isCapable = isPossible(mid, weights, D);
		if (isCapable) {
			//search for lower
			return binarySearch(low, mid, weights, D);
		} else {
			return binarySearch(mid+1,high, weights, D);
		}

	}

	public static boolean isPossible(int shipCapacity, int[] weights, int D) {
		int sum = 0;
		int days = 0;
		for (int i = 0; i < weights.length; i++) {
			sum = sum + weights[i];
			if (sum > shipCapacity) {
				days++;
				sum = weights[i];
			}
		}
		days++;
		if (days <= D) {
			return true;
		} else {
			return false;
		}

	}
}
