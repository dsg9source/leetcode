package Greedy;

public class deleteColumnsToMakeSorted {
	public static void main(String args[]) {
		
	//	https://leetcode.com/problems/delete-columns-to-make-sorted
		
		//accepted in leetcode and official solutionalso talks about n^2 approach only
		//this is greedy approach

	}
	
	 public int minDeletionSize(String[] A) {
		 	int counter=0;
	        int strLength=A[0].length();
	        for(int i=0;i<strLength;i++) {
	        	for(int j=0;j<A.length-1;j++) {
	        		if(A[j].charAt(i)>A[j+1].charAt(i)){
	        			counter++;
	        			break;
	        		}
	        	}
	        }
	        return counter;
	        
	 }
}
