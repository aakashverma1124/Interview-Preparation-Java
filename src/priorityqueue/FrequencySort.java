import java.util.*;
import java.io.*;

class FrequencySort {

	public static String sortCharacters(String s) {
		Map<Character, Integer> hashMap = new HashMap<>();
		for(char ch : s.toCharArray()) {
			hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
			new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			maxHeap.offer(entry);
		}

		StringBuilder ans = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for(int i = 0; i < entry.getValue(); i++) {
				ans.append(entry.getKey());
			}
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		String s = "apaprsqpp";
		String ans = FrequencySort.sortCharacters(s);
		System.out.println(ans);
	}
}
