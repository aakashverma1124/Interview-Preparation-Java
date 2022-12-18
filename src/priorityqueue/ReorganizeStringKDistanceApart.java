import java.util.*;

class ReorganizeStringKDistanceApart {

	public static String reorganizeString(String s, int k) {
		
		Map<Character, Integer> hashMap = new HashMap<>();
		for(char ch : s.toCharArray()) {
			hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
			new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			maxHeap.offer(entry);
		}

		StringBuilder result = new StringBuilder();

		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			result.append(entry.getKey());
			entry.setValue(entry.getValue() - 1);
			queue.offer(entry); 
			if(queue.size() == k) {
				Map.Entry<Character, Integer> queueFront = queue.poll();
				if(queueFront.getValue() > 0) {
					maxHeap.offer(queueFront);
				}
			}
		}

		if(result.length() == s.length()) {
			return result.toString();
		} else {
			return "";
		}

	}

	public static void main(String[] args) {
		String s = "aabbcc";
		int k = 3;
		String ans = reorganizeString(s, k);
		System.out.println(ans);
	}
}