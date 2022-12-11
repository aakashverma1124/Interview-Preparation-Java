import java.util.*;

class LongestSubstringAfterReplacement {

	public static int maxLength(String s, int k) {
		int windowStart = 0;
		int maxLength = Integer.MIN_VALUE;
		int maximumFrequency = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char currChar = s.charAt(windowEnd);
			map.put(currChar, map.getOrDefault(currChar, 0) + 1);
			maximumFrequency = Math.max(maximumFrequency, map.get(currChar));
			if((windowEnd - windowStart + 1) - maximumFrequency > k) {
				char leftChar = s.charAt(windowStart);
				map.put(leftChar, map.get(leftChar) - 1);
				windowStart += 1;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
	public static void main(String[] args) {
		String s = "ababbab";
		System.out.println(LongestSubstringAfterReplacement.maxLength(s, 2));
	}
}