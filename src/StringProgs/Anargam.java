package StringProgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anargam {
	public static void main(String[] args) {
		String s="ABCD";
		char[] arr=new char[s.length()];
		List<Character> charList=new ArrayList<Character>();
		for(Character ch:s.toCharArray()) {
			charList.add(ch);
		}
		List<String> allAnagrams=new ArrayList<String>();
		recursiveAnagram(0, s.length(), arr, allAnagrams, charList);
		System.out.println(allAnagrams.size());
		for(String str:allAnagrams) {
			System.out.println(str);
		}
		
	}

	public static void recursiveAnagram(int position,int strLength,char[] arr,List<String> allAnagrams,List<Character> charList) {
		if(position>=strLength) {
			allAnagrams.add(String.valueOf(arr));
			return;
		}
		for(int i=0;i<charList.size();i++) {
			arr[position]=charList.get(i);
			charList.remove(i);
			recursiveAnagram(position+1, strLength, arr, allAnagrams, charList);
			charList.add(i,arr[position]);
			arr[position]='\u0000';
			
		}
		return;
	}
}
