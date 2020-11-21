package Greedy;

public class WaterBottles {
	public static void main(String[] args) {
	//	https://leetcode.com/problems/water-bottles/submissions/
	}

	public static int numWaterBottles(int numBottles, int numExchange) {
        
		int counter=0;
		while(numBottles!=0 && numBottles>0) {
			numBottles=numBottles-numExchange;
			if(numBottles>=0) {
				counter=counter+numExchange;
				numBottles++;
			}else {
				counter=counter+numExchange+numBottles;
			}
		}
		return counter;
	
    }
}
