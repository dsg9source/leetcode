package UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestConsecutiveSequence {
	public static void main(String args[]) {
		int[] input = {1,-8,7,-2,-4,-4,6,3,-4,0,-7,-1,5,1,-9,-3};
		System.out.println(longestConsecutive(input));
	}

	public static int longestConsecutive(int[] nums) {
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
		Map<Integer,Boolean> isParent=new HashMap<Integer,Boolean>();
		for (int i = 0; i < nums.length; i++) {
			
			if (parent.containsKey(nums[i])) {
				// parent wont change but total no of elements in parent will be increases
				// further
				//int p1 = find(nums[i],parent);
				//parent.put(p1, parent.get(p1) - 1);
			} else {
				parent.put(nums[i], -1);
				isParent.put(nums[i],true);
				if (parent.containsKey(nums[i] + 1) && parent.containsKey(nums[i] - 1)) {
					union(nums[i] + 1, nums[i] - 1, parent,isParent);
					union(nums[i] + 1, nums[i], parent,isParent);
				} else if (parent.containsKey(nums[i] + 1)) {
					union(nums[i] + 1, nums[i], parent,isParent);
				} else if (parent.containsKey(nums[i] - 1)) {
					union(nums[i] - 1, nums[i], parent,isParent);
				}

			}
		}
		int longest = 0;
		for (Entry<Integer, Integer> entry : parent.entrySet()) {
			if (entry.getValue() < 0 && isParent.get(entry.getKey())) {
				if (Math.abs(entry.getValue()) > longest) {
					longest = Math.abs(entry.getValue());
				}
			}

		}
		return longest;
	}

	public static int find(int x, Map<Integer, Integer> parent,Map<Integer,Boolean> isParent) {
		if (parent.get(x) < 0) {
			if(isParent.get(x)) {
				return x;
			}else {
				return find(parent.get(x),parent,isParent);
			}
			
		} else {
			return find(parent.get(x), parent,isParent);
		}
	}

	public static void union(int r1, int r2, Map<Integer, Integer> parent,Map<Integer,Boolean> isParent) {
		int p1 = find(r1, parent,isParent); 
		int p2 = find(r2, parent,isParent); 
		if (parent.get(p1) < parent.get(p2)) {
			parent.put(p1, parent.get(p1) + parent.get(p2));
			parent.put(p2, p1);
			isParent.put(p2, false);
		} else {
			parent.put(p2, parent.get(p2) + parent.get(p1));
			parent.put(p1, p2);
			isParent.put(p1,false);
		}

	}
}
