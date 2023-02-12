import java.util.*;

class PermutationInString {
	public static boolean isFound(String s, String p) {
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : p.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int windowStart = 0;
		int matched = 0;

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char currChar = s.charAt(windowEnd);
			if(map.containsKey(currChar)) {
				map.put(currChar, map.get(currChar) - 1);
				if(map.get(currChar) == 0) {
					matched += 1;
				}
			}

			if(matched == map.size()) {
				return true;
			}

			if(windowEnd >= p.length() - 1) {
				char leftChar = s.charAt(windowStart);
				windowStart += 1;
				if(map.containsKey(leftChar)) {
					if(map.get(leftChar) == 0) {
						matched -= 1;
					}
					map.put(leftChar, map.get(leftChar) + 1);
				}
			}

		}
		return false;
	}
}