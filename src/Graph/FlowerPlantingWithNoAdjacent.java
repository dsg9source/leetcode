package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FlowerPlantingWithNoAdjacent {
	public static void main(String[] args) {
		int[][] paths = new int[][] { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.toString(gardenNoAdj(4, paths)));
	}

	public static int[] gardenNoAdj(int n, int[][] paths) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < paths.length; i++) {
			int source = paths[i][0];
			int dest = paths[i][1];
			if (map.containsKey(source)) {
				map.get(source).add(dest);
			} else {
				List<Integer> node = new ArrayList<Integer>();
				node.add(dest);
				map.put(source, node);
			}
			if (map.containsKey(dest)) {
				map.get(dest).add(source);
			} else {
				List<Integer> node = new ArrayList<Integer>();
				node.add(source);
				map.put(dest, node);
			}
		}
		int[] color = new int[n + 1];
		for (int i = 0; i < color.length; i++) {
			color[i] = 1;
		}

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int[] avaiableColor = new int[5];
			for (Integer garden : entry.getValue()) {
				if (color[garden] != 0) {
					avaiableColor[color[garden]] = 1;
				}
			}
			for (int i = 1; i <= 4; i++) {
				if (avaiableColor[i] == 0) {
					color[entry.getKey()] = i;
					break;
				}
			}

		}
		int[] output = new int[color.length - 1];
		for (int i = 1; i < color.length; i++) {

			output[i - 1] = color[i];

		}
		return output;
	}

}
