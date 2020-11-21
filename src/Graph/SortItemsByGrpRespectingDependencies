package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SortItemsByGrpRespectingDependencies {
	public static void main(String[] args) {

	}

	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
       int[][] adjMatrix= createAdjMatrixForItems(beforeItems,n);
       for(int[] row:adjMatrix){
    	   System.out.println(row);
       }
       int[][] adjMatrixGroup=new int[m][m];
       Set<Integer> visitedVertices=new HashSet<Integer>();
       Set<Integer> recStack=new HashSet<Integer>();
       Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();)
       topologicalSortByGroups(adjMatrix,visitedVertices,recStack);
       List<Integer> groupOrdering=topologicalSortAmongGroups(adjMatrixGroup);
       for(Integer grp:groupOrdering) {
    	   //insert into output array
       }
    }

	private void topologicalSortByGroups(int[][] adjMatrix, Set<Integer> visitedVertices, Set<Integer> recStack,int[] group,int[][] adjMatrixGroup) {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if(adjMatrix[i][j]==1) {
						if(group[i]==group[j]) {
							
						}else {
							//add entry for different group dependency in dependency matrix
							adjMatrixGroup[group[i]][group[i]]=1; //problem with non grouped eleemtns -1 how to handle them??
						}
				}
			}
		}

	}

	private int[][] createAdjMatrixForItems(List<List<Integer>> beforeItems, int n) {
		int[][] adjMatrix = new int[n][n];
		ListIterator<List<Integer>> itr = beforeItems.listIterator();
		while (itr.hasNext()) {
			int col = itr.nextIndex();
			List<Integer> rows = itr.next();
			for (Integer row : rows) {
				adjMatrix[row][col] = 1;
			}
		}
		return adjMatrix;
	}

}
