import java.util.*;

class KDistinctCharacters {

	public static int maxLength(String s, int k) {
		int windowStart = 0;
		int ansStart = 0;
		int ansEnd = 0;
		int maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char currChar = s.charAt(windowEnd);
			map.put(currChar, map.getOrDefault(currChar, 0) + 1);
			while(map.size() > k) {
				char leftChar = s.charAt(windowStart);
				map.put(leftChar, map.get(leftChar) - 1);
				if(map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				windowStart += 1;
			}
			// maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
			if(windowEnd - windowStart + 1 > maxLength) {
				maxLength = windowEnd - windowStart + 1;
				ansStart = windowStart;
				ansEnd = windowEnd;
			}
		}
		System.out.println(s.substring(ansStart, ansEnd + 1));
		return maxLength;
	}
	public static void main(String[] args) {
		String s = "aaabccccbcd";
		System.out.println(KDistinctCharacters.maxLength(s, 2));
	}
}