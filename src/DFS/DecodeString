package DFS;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {

		// https://leetcode.com/problems/decode-string/

		//System.out.println(decodeString("abc3[a2[c]]xyz"));
		System.out.println(decodeString("100[a]"));
	}

	public static String decodeString(String s) {
		if(s==null || s.isEmpty()) {
			return s;
		}
		StringBuilder finalString = new StringBuilder();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				int startIndex = i;
				int endIndex = -1;
				int countBracket = 0;
				while(arr[i]!='[') {
					i++;
				}
				countBracket++;				
				
				
				while (countBracket > 0) {
					i++;
					if (arr[i] == ']') {
						countBracket--;
					}
					if (arr[i] == '[') {
						countBracket++;
					}
					if (countBracket == 0) {
						endIndex = i;
						countBracket--;
					}

				}
				finalString.append(decode(arr, startIndex, endIndex));

			} else {
				finalString.append(arr[i]);

			}
		}
		return finalString.toString();
	}

	private static String decode(char[] arr, int startIndex, int endIndex) {
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> charStack = new Stack<Character>();
		String totalString = new String();
		for (int i = startIndex; i <= endIndex; i++) {
			if (Character.isDigit(arr[i])) {
				int digitStart=i;
				i++;
				int digitEnd=-1;
				while(Character.isDigit(arr[i])) {
					i++;
				}
				i--;
				digitEnd=i;
				
				numStack.push(Integer.parseInt(String.valueOf(arr,digitStart,digitEnd-digitStart+1)));
			} else if (arr[i] == ']') {
				StringBuilder temp = new StringBuilder();
				int repeatCount = numStack.pop();
				char poppedChar = charStack.pop();
				while (poppedChar != '[') {
					temp = temp.insert(0, poppedChar);
					poppedChar = charStack.pop();
				}
				StringBuilder sb = new StringBuilder();
				for (int j = 1; j <= repeatCount; j++) {
					sb.append(temp);
				}
				if(!charStack.isEmpty()) {
					char[] sbArray=sb.toString().toCharArray();
					for(int k=0;k<sbArray.length;k++) {
						charStack.push(sbArray[k]);
					}
					
				}else {
					return  sb.toString();
				}
				

			} else {
				charStack.push(arr[i]);
			}
		}
		return totalString;
	}
}
