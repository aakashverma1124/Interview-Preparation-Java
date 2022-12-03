import java.util.*;

class NoRepeatSubString {

	public static int findLength(String s) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			if(map.containsKey(rightChar)) {
				windowStart = Math.max(windowStart, map.get(rightChar) + 1);
			}
			map.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "aabccbb";
		int length = findLength(s);
		System.out.println(length);
	}
}