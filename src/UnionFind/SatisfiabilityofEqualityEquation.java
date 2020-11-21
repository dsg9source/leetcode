package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SatisfiabilityofEqualityEquation {
	public static void main(String[] args) {
		String[] eqns = new String[] { "a==b", "b==c", "a==c" };
		System.out.println(equationsPossible(eqns));
	}

	public static boolean equationsPossible(String[] equations) {
		List<String> operations = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		for (String eqn : equations) {
			String var1 = eqn.substring(0, 1);
			String var2 = eqn.substring(3);
			String operand = eqn.substring(1, 3);
			if (operand.equals("!=")) {
				operations.add(eqn);
			} else {
				union(var1, var2, map);
			}
		}
		for (String ops : operations) {
			String var1 = ops.substring(0, 1);
			String var2 = ops.substring(3);
			if (find(var1, map).equalsIgnoreCase(find(var2, map))) {
				return false;
			}
		}
		return true;
	}

	public static void union(String var1, String var2, Map<String, String> map) {
		if (!map.containsKey(var1) && !map.containsKey(var2)) {
			if (!var1.equalsIgnoreCase(var2)) {
				map.put(var1, null);
				map.put(var2, var1);
			}

		} else if (!map.containsKey(var1) && map.containsKey(var2)) {
			String parentVar2 = find(var2, map);
			map.put(var1, parentVar2);

		} else if (map.containsKey(var1) && !map.containsKey(var2)) {
			String parentVar1 = find(var1, map);
			map.put(var2, parentVar1);

		} else if (map.containsKey(var1) && map.containsKey(var2)) {
			String parentVar1 = find(var1, map);
			String parentVar2 = find(var2, map);
			if (!parentVar1.equalsIgnoreCase(parentVar2)) {
				map.put(parentVar1, parentVar2);
			}

		}
	}

	public static String find(String var1, Map<String, String> map) {
		if (map.containsKey(var1)) {
			if (map.get(var1) == null) {
				return var1;
			} else {
				map.put(var1, find(map.get(var1), map));
				return map.get(var1);
			}
		} else {
			map.put(var1, null);
			return var1;
		}

	}

}
