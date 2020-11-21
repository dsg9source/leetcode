package BinarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOFElementInSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] { 8, 8};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}

	public static int[] searchRange(int[] nums, int target) {

		int[] output = new int[2];
		if (nums.length == 0) {
			output[0] = -1;
			output[1] = -1;
			return output;
		}
		output[0] = binarySearch(0, nums.length - 1, nums, target, 1);
		output[1] = binarySearch(0, nums.length - 1, nums, target, 2);
		return output;
	}
	public static int binarySearch(int start, int end, int[] nums, int target, int mode) {
		if(start>end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (start == end && target != nums[mid]) {
			return -1;
		}
		if (start == end && target == nums[mid]) {
			return mid;
		}
		if (target > nums[mid]) {
			return binarySearch(mid + 1, end, nums, target, mode);
		}
		if (target < nums[mid]) {

				return binarySearch(start, mid - 1, nums, target, mode);

		}
		if (target == nums[mid]) {
			int lowerBound;
			int upperBound;
			if (mode == 1) {
				lowerBound = binarySearch(start, mid - 1, nums, target, 1);
				if (lowerBound == -1) {
					return mid;
				} else {
					return lowerBound;
				}
			}
			if (mode == 2) {
				upperBound = binarySearch(mid + 1, end, nums, target, 2);
				if (upperBound == -1)
					return mid;
				else
					return upperBound;
				
			}

		
		}
		return -1;
		
		
		
	}

/*	public static int binarySearch(int start, int end, int[] nums, int target, int mode) {
		int mid = (start + end) / 2;
		if (start == end && target != nums[mid]) {
			return -1;
		}
		if (start == end && target == nums[mid]) {
			return mid;
		}
		if (target > nums[mid]) {
			return binarySearch(mid + 1, end, nums, target, mode);
		}
		if (target < nums[mid]) {
			if (start <= mid - 1) {
				return binarySearch(start, mid - 1, nums, target, mode);
			}
		}
		if (target == nums[mid]) {
			int lowerBound;
			int upperBound;
			if (mode == 1) {
				if (start <= mid - 1) {
					lowerBound = binarySearch(start, mid - 1, nums, target, 1);
					if (lowerBound == -1) {
						return mid;
					} else {
						return lowerBound;
					}
				} else {
					return mid;
				}
			}
			if (mode == 2) {
				if (mid + 1 <= end) {
					upperBound = binarySearch(mid + 1, end, nums, target, 2);
					if (upperBound == -1)
						return mid;
					else
						return upperBound;
				}else {
					return mid;
				}
			}

		}
		return -1;

	}*/
}
