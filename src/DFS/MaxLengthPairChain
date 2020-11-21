package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthPairChain {
	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 7, 8 }, { 12, 13 }, { 8, 9 } };
		System.out.println(findLongestChain(input));
	}

	public static int findLongestChain(int[][] pairs) {
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		Set<List<List<Integer>>> listOfPairChain = new HashSet<List<List<Integer>>>();
		for (int i = 0; i < pairs.length; i++) {
			dfsVisit(i, pairs, temp, listOfPairChain);
		}
		int lengthCount = Integer.MIN_VALUE;
		for (List<List<Integer>> chain : listOfPairChain) {
			if (chain.size() > lengthCount) {
				lengthCount = chain.size();
			}

		}
		if (lengthCount == Integer.MIN_VALUE) {
			return 0;
		} else {
			return lengthCount;
		}
	}

	private static void dfsVisit(int i, int[][] pairs, List<List<Integer>> temp,
			Set<List<List<Integer>>> listOfPairChain) {
		// TODO Auto-generated method stub
		int[] visited = pairs[i];
		List<Integer> arrList = new ArrayList<Integer>();
		arrList.add(visited[0]);
		arrList.add(visited[1]);
		temp.add(arrList);

		boolean flag = false;
		for (int j = 0; j < pairs.length; j++) {
			if (pairs[j][0] > pairs[i][1]) {

				flag = true;
				dfsVisit(j, pairs, temp, listOfPairChain);
			}
		}
		if (!flag) {
			listOfPairChain.add(new ArrayList<List<Integer>>(temp));
		}
		temp.remove(temp.size() - 1);

		return;
	}
}
