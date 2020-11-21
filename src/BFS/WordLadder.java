package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String args[]) {
		List<String> wordList=new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ladderLength("hit", "cog", wordList));
		
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList.size()==0) {
			return 0;
		}
		Queue<String> q=new LinkedList<String>();
		Set<String> set=new HashSet<String>();
		q.offer(beginWord);
		int seqLength=0;
		while(!q.isEmpty()) {
			seqLength++;
			int qSize=q.size();
			while(qSize>0) {
				String word=q.poll();
				if(word.equals(endWord)) {
					return seqLength;
				}else {
					List<String> nextWords=findAllDictionaryWordsWithDistance1(word,wordList);
					for(String nextWord:nextWords) {
						if(!set.contains(nextWord)) {
							q.offer(nextWord);
							set.add(nextWord);
						}
						
					}
				}
				qSize--;
			}
			
			
			
		}
		return 0;
	}

	private static  List<String> findAllDictionaryWordsWithDistance1(String word, List<String> wordList) {
		List<String> returnList=new ArrayList<String>();
		for(String wrd:wordList) {
			char[] arr=wrd.toCharArray();
			char[] wordArray=word.toCharArray();
			int counter=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=wordArray[i]) {
					counter++;
				}
			}
			if(counter==1) {
				returnList.add(wrd);
			}
		}
		return returnList;
	}
}
