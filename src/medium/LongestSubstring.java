package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    private int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        //int count = 0;
        int max = 0;
        int left = 0;
        //int pointer = 0; //not part of the problem description to write the substring

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                while (map.containsKey(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            max = Math.max(max, ((right - left) + 1));
            map.put(s.charAt(right), right);

        }

        return max;

    }


    LongestSubstring(String s) {
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static void main(String args[]) {
        String s = "bbbbb";
        new LongestSubstring(s);
    }
}
