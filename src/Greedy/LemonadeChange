package Greedy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
	public static void main(String[] args) {

	}

	public boolean lemonadeChange(int[] bills) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(5, 0);
		map.put(10, 0);
		map.put(20, 0);
		for (int i = 0; i < bills.length; i++) {
			if(bills[i]==5) {
				map.put(5,map.get(5)==null?1:map.get(5)+1);
			}
			if(bills[i]==10) {
				map.put(10,map.get(10)==null?1:map.get(10)+1);
				if(map.get(5)>0) {
					map.put(5, map.get(5)-1);
				}else {
					return false;
				}
			}
			if(bills[i]==20) {
				map.put(20,map.get(20)==null?1:map.get(20)+1);
				if(map.get(10)>0 && map.get(5)>0) {
					map.put(5, map.get(5)-1);
					map.put(10, map.get(10)-1);
				}
				else if(map.get(10)>0 && map.get(5)<=0) {
					return false;
				}
				else if(map.get(10)<=0 && map.get(5)>=3) {
					map.put(5, map.get(5)-3);
				}
				else if(map.get(10)<=0 && map.get(5)<3) {
					return false;
				}
				
			}
		}
		return true;

	}
}
