package Greedy;

public class BulbsINterViewBit {

	public static void main(String[] args) {
		int[] A = new int[] {0 ,1, 0, 1};
		System.out.println(bulbs(A));
		
	}

	/*public int bulbs(int[] A) {
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				A[i] = 1;
				counter++;
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] == 1) {
						A[j] = 0;
					} else if (A[j] == 0) {
						A[j] = 1;
					}
				}
			}
		}
		return counter;
	} */  // bruteforce solution works well but slow
	   public static int bulbs(int[] A) {
	        int counter=0;
	        for(int i=0;i<A.length;i++){
	            if(A[i]==0 && counter%2==0){
	                A[i]=1;
	                counter++;
	                continue;
	            }
	            
	            if(A[i]==1 &&counter%2==1){
	                A[i]=1;
	                counter++;
	                continue;
	            }
	        }
	        return counter;
	    }
}
