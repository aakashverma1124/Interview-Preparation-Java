import java.util.*;
import java.io.*;

class SubarrayWithKDistinctCharacters {

    public static int maxSubarrayWithKDistinctCharacters(String s, int k) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            // invalid window case, we need to shrink the window until the window becomes valid
            while(map.size() > k) {
                char leftChar = s.charAt(windowStart);
                windowStart += 1;
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abacdcdcdabcd";
        int k = 3;
        System.out.println(SubarrayWithKDistinctCharacters.maxSubarrayWithKDistinctCharacters(s, k));
    }
}