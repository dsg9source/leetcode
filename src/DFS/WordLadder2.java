package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder2 {
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(findLadders("hit", "cog", wordList));
		
		//this soltn does not work for very large input data
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> global = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		dfs(beginWord, temp, global, wordList, endWord);
		int shortestSequenceSize=Integer.MAX_VALUE;
		for(int i=0;i<global.size();i++) {
			if(global.get(i).size()<shortestSequenceSize) {
				shortestSequenceSize=global.get(i).size();
			}
		}
		List<List<String>> g=new ArrayList<List<String>>();
		for(List<String> l:global) {
			if(l.size()==shortestSequenceSize) {
				g.add(l);
			}
		}
		
		
		return g;
	}

	private static void dfs(String beginWord, List<String> temp, List<List<String>> global, List<String> wordList,
			String target) {
		temp.add(beginWord);
		if (beginWord.equals(target)) {
			global.add(new ArrayList<String>(temp));

		} else {
			List<String> words = findAllDictionaryWordsWithDistance1(beginWord, wordList);
			for (String word : words) {
				if (!temp.contains(word)) {
					dfs(word, temp, global, wordList, target);
				}
			}
		}
		temp.remove(temp.size() - 1);

	}

	private static List<String> findAllDictionaryWordsWithDistance1(String word, List<String> wordList) {
		List<String> returnList = new ArrayList<String>();
		for (String wrd : wordList) {
			char[] arr = wrd.toCharArray();
			char[] wordArray = word.toCharArray();
			int counter = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != wordArray[i]) {
					counter++;
				}
			}
			if (counter == 1) {
				returnList.add(wrd);
			}
		}
		return returnList;
	}
}
