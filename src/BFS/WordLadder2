package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder2 {

	public static void main(String[] args) {

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

	 public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
		 if(wordList.size()==0) {
				return 0;
			}
			Queue<String> q=new LinkedList<String>();
		//	Set<String> set=new HashSet<String>();
			Map<String,List<String>> map=new HashMap<String,List<String>>();
			boolean isShortestPathFound=false;
			q.offer(beginWord);
			map.put(beginWord, null);
			while(!q.isEmpty()) {
				int qSize=q.size();
				while(qSize>0) {
					String word=q.poll();
					if(word.equals(endWord)) {
						isShortestPathFound=true;
						
					}else {
						List<String> nextWords=findAllDictionaryWordsWithDistance1(word,wordList);
						for(String nextWord:nextWords) {
							if( !isShortestPathFound) {
								if(map.containsKey(nextWord)) {
									List<String> val=map.get(nextWord);
									val.add(word);
									map.put(nextWord,val);
								}
								q.offer(nextWord);
								//set.add(nextWord);
							}
							
						}
					}
					qSize--;
				}
				
			}
			return constructAllShortestPathFromMap( map,endWord );
			
			
	 }

	private static List<List<String>> constructAllShortestPathFromMap(Map<String, List<String>> map, String endWord) {
		List<String> parents=map.get(endWord);
		for(String parent:parents) {
			Stack<String> stack=new Stack<String>();
			stack.push(endWord);
			while(parent!=null) {
				stack.push(parent);
				parent.
			}
		}
	}
}
