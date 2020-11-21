package Greedy;

public class IsSubsequence {
	public static void main(String[] args) {
//https://leetcode.com/problems/is-subsequence
	}

	public boolean isSubsequence(String s, String t) {
		if (s.isEmpty()) {
			return true;
		}
		char[] str = t.toCharArray();
		char[] pattern = s.toCharArray();
		int i = 0, j = 0;
		while (j < str.length && i < pattern.length) {
			if (pattern[i] == str[j]) {
				j++;
				i++;

			} else {
				j++;
			}
		}
		if (i>=pattern.length) {
			return true;
		} else {
			return false;
		}

	}
}
