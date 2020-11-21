package BinarySearch;

public class MinOpsToReduceXToZero {
	public static void main(String[] args) {
		int[] nums=new int[] {/*5,6,7,8,9*/
				/*8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309*/
				5,4,3,20,2,1
				/*1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136
*/				
				
				//soltn works for a small set
				//as this generates a huge population
				
						
		};
		System.out.println(minOperations(nums,20));
	}

	public static int minOperations(int[] nums, int x) {
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int stepsStart = bfs(startIndex, startIndex + 1, endIndex, 0, x, nums);
		int stepsEnd = bfs(endIndex, startIndex, endIndex - 1, 0, x, nums);
		if (stepsStart == -1 && stepsEnd == -1) {
			return -1;
		} else if (stepsStart == -1 && stepsEnd != -1) {
			return stepsEnd;
		} else if (stepsStart != -1 && stepsEnd == -1) {
			return stepsStart;
		} else if (stepsStart < stepsEnd) {
			return stepsStart;
		} else {
			return stepsEnd;
		}
	}

	private static int bfs(int currentIndex, int startIndex, int endIndex, int level, int x, int[] nums) {
		System.out.println(startIndex+" "+endIndex+" "+currentIndex);
		if (startIndex > endIndex && currentIndex>endIndex) {
			return -1;
		}
		level++;
		if (x - nums[currentIndex] == 0) {
			return level;
		} else if (x - nums[currentIndex] < 0) {
			return -1;
		} else {
			int stepStart = bfs(startIndex, startIndex + 1, endIndex, level, x - nums[currentIndex], nums);
			int stepEnd = bfs(endIndex, startIndex, endIndex - 1, level, x - nums[currentIndex], nums);
			if (stepStart == -1 && stepEnd == -1) {
				return -1;
			} else if (stepStart == -1 && stepEnd != -1) {
				return stepEnd;
			} else if (stepStart != -1 && stepEnd == -1) {
				return stepStart;
			} else if (stepStart < stepEnd) {
				return stepStart;
			} else {
				return stepEnd;
			}
		}

	}
}
