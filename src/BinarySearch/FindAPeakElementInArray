package BinarySearch;

public class FindAPeakElementInArray {
	public static void main(String[] args) {
		int[] arr=new int[] {2,2,2,2,2,1,1};
		System.out.println(findPeakElement(arr));
	}

	public static int findPeakElement(int[] nums) {
		return binarySearch(0, nums.length - 1, nums);
	}

	private static int binarySearch(int start, int end, int[] nums) {
		if(nums.length==1) {
			return 0;
		}
		if (start <= end) {
			int mid = (start + end) / 2;
			if (mid == 0) {
				if (nums[mid] >= nums[mid + 1]) {
					return mid;
				} else {
					return binarySearch(mid + 1, end, nums);
				}
			}
			if (mid == nums.length - 1) {

				if (nums[mid] >= nums[mid - 1]) {
					return mid;
				} else {
					return binarySearch(start, mid - 1, nums);
				}

			}

			if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) {
				return mid;
			} else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				return binarySearch(mid + 1, end, nums);
			} else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return binarySearch(start, mid - 1, nums);
			} else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				if (nums[mid - 1] > nums[mid + 1]) {
					return binarySearch(start, mid - 1, nums);
				} else {
					return binarySearch(mid + 1, end, nums);
				}

			}

		}
		return -1;
	}

}
