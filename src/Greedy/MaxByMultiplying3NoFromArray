package Greedy;

public class MaxByMultiplying3NoFromArray {

	public static void main(String[] args) {
		int[] A=new int[] {0, -1, 3, 100, 70, 50};
		System.out.println(maxp3(A));
		
	}
    public static  int maxp3(int[] A) {
    	
    	int highestNumber=0,secondHighestNumber=0,thirdHIghestNumber=0;
    	for(int i=0;i<A.length;i++) {
    		if(A[i]>highestNumber) {
    			thirdHIghestNumber=secondHighestNumber;
    			secondHighestNumber=highestNumber;
    			highestNumber=A[i];
    		}else if(A[i]>secondHighestNumber) {
    			thirdHIghestNumber=secondHighestNumber;
    			secondHighestNumber=A[i];
    			
    		}else if(A[i]>thirdHIghestNumber) {
    			thirdHIghestNumber=A[i];
    		}
    	}
    	return highestNumber*secondHighestNumber*thirdHIghestNumber;
    }
}
