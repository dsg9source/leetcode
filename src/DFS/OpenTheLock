package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenTheLock {
	public static void main(String[] args) {
		String[] deadEnds=new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String target="8888";
		System.out.println("Ans is "+openLock(deadEnds,target));
		//dfs works but needs lot of memory hence bfs is the preferred choice here
		//we are looking for minimum distance hence bfs always finds the min here first
		//dfs populates all 9999 combinations which is huge for the given memory distribution
		//recstack is used to track a combination iwhich is laready explored otherwise it would hae been infinte loop
		
	}

	public static int openLock(String[] deadends, String target) {
		Set<String> recStack=new HashSet<String>();
		List<Integer> pathList=new ArrayList<Integer>();
		Set<String> deadEnd=new HashSet<String>();
		for(String dead:deadends) {
			deadEnd.add(dead);
		}
		
		dfsVisit("0000",recStack,pathList,deadEnd,target,0);
		int min=Integer.MAX_VALUE;
		System.out.println(pathList.size());
		for(Integer val:pathList) {
			System.out.println(val);
			if(val<min) {
				min=val;
			}
		}
		
		if(pathList.size()<=0) {
			min=-1;
		}
		return min;
	}

	public static void dfsVisit(String no, Set<String> recStack, List<Integer> pathLength, Set<String> deadends,
			String target,int level) {
		System.out.println(recStack.size());
		if (no.equals(target)) {
			pathLength.add(level);
			return;
		}
		if(deadends.contains(no)) {
			return;
			
		}
		recStack.add(no);
		List<String> allPossibleStrings=fetchAllPossibleCombinations(no);
		for(String possibility:allPossibleStrings) {
			if(!recStack.contains(possibility)) {
				dfsVisit(possibility, recStack, pathLength, deadends, target, level+1);
			}
		}
		//recStack.remove(no);
		
		return;
		
	}

	private static List<String> fetchAllPossibleCombinations(String no) {
		List<String> retList=new ArrayList<String>();
		for(int i=0;i<4;i++) {
			int k=Integer.parseInt(no.substring(i,i+1));
			String s=no.substring(0,i)+String.valueOf((k+1)%10)+no.substring(i+1,no.length());
			retList.add(s);
			if(k-1<0) {
				k=10+k-1;
			}else {
				k=k-1;
			}
			String ss=no.substring(0,i)+String.valueOf(k)+no.substring(i+1,no.length());
			retList.add(ss);
		}
		
		return retList;
	}


}
