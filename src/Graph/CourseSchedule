package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {
	public static void main(String[] args) {
		int[][] input = new int[][] {/*{0,2},{1,2},{1,6},{6,4},{4,5},{3,4},{2,3} */{1,0},{0,1}};
		System.out.println(canFinish(2, input));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] adjMatrix = new int[numCourses][numCourses];
		Stack<Integer> globalStack = new Stack<Integer>();
		Set<Integer> recStack = new HashSet<Integer>();
		Set<Integer> visitedVertexSet = new HashSet<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			adjMatrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}

		for (int i = 0; i < adjMatrix.length; i++) {
			if (!recStack.contains(i)) {
				boolean isCycle = topologicalSort(i, globalStack, recStack, adjMatrix, visitedVertexSet);
				if (!isCycle) {
					return isCycle;
				}
			}
		}
	while (!globalStack.isEmpty()) {
			System.out.println(globalStack.pop());
		}
		return true;

	}

	private static boolean topologicalSort(int i, Stack<Integer> globalStack, Set<Integer> recStack, int[][] adjMatrix,
			Set<Integer> visitedVertexSet) {
		recStack.add(i);
		if (visitedVertexSet.contains(i)) {
			recStack.remove(i);
			return true;
		}
		visitedVertexSet.add(i);
		for (int j = 0; j < adjMatrix[0].length; j++) {
			if (adjMatrix[i][j] == 1) {
				if (recStack.contains(j)) {
					// cycle detected
					return false;
				} else {
					boolean isCycleDetected = topologicalSort(j, globalStack, recStack, adjMatrix, visitedVertexSet);
					if (!isCycleDetected) {
						return isCycleDetected;
					}
				}
			}
		}

		globalStack.push(i);

		recStack.remove(i);
		return true;
	}
}
