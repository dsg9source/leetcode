package Greedy;

public class SplitInBalancedString {
//https://leetcode.com/problems/split-a-string-in-balanced-strings/
	
	public static void main(String args[]) {
		//accepted in leetcode
	}
	public static  int splitInBalancedString(String s) {
		int counter=0;
		int lCounter=0;
		int rCounter=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='L') {
				lCounter++;
				if(lCounter==rCounter) {
					counter++;
					lCounter=0;
					rCounter=0;
				}
			}else if(s.charAt(i)=='R') {
				rCounter++;
				if(lCounter==rCounter) {
					counter++;
					lCounter=0;
					rCounter=0;
				}
			}
		}
		return counter;
	}
}
