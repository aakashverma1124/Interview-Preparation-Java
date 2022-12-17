import java.util.*;
import java.io.*;

class ReorganizeString {

	public static String reorganizeString(String s) {
		
		Map<Character, Integer> hashMap = new HashMap<>();
		for(char ch : s.toCharArray()) {
			hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
			new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			maxHeap.offer(entry);
		}
		
		StringBuilder res = new StringBuilder();
		while(maxHeap.size() >= 2) {
			Map.Entry<Character, Integer> entry1 = maxHeap.poll();
			Map.Entry<Character, Integer> entry2 = maxHeap.poll();
			res.append(entry1.getKey());
			res.append(entry2.getKey());
			entry1.setValue(entry1.getValue() - 1);
			entry2.setValue(entry2.getValue() - 1);
			if(entry1.getValue() > 0) {
				maxHeap.offer(entry1);
			}
			if(entry2.getValue() > 0) {
				maxHeap.offer(entry2);
			}
		}
		
		if(maxHeap.isEmpty()) {
			return res.toString();
		} else {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			if(entry.getValue() == 1) {
				res.append(entry.getKey());
				return res.toString();
			} else {
				return "";
			}
		}
	}
	public static void main(String[] args) {
		String s = "aaabcdddaa";
		String ans = ReorganizeString.reorganizeString(s);
		System.out.println(ans);
	}
}
