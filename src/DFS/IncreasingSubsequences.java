package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 1, 1 };
		List<List<Integer>> sub = findSubsequences(nums);
		for (List<Integer> l : sub) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> increasingSubsequences = new HashSet<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			dsfVisit(i, nums, temp, increasingSubsequences);
		}
		return new ArrayList<List<Integer>>(increasingSubsequences);
	}

	private static void dsfVisit(int index, int[] nums, List<Integer> temp,
			Set<List<Integer>> increasingSubsequences) {
		temp.add(nums[index]);
		if (temp.size() >= 2) {
			increasingSubsequences.add(new ArrayList<Integer>(temp));
		}

		for (int k = index + 1; k < nums.length; k++) {

			if (nums[k] >= nums[index]) {
				dsfVisit(k, nums, temp, increasingSubsequences);
			}

		}
		temp.remove(temp.size() - 1);

	}
}
