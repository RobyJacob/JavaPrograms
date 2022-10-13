import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {
    static String longestSubstring(String str) {
        int l = 0, r = 0, len = 0;
        HashMap<Integer, String> substrings = new HashMap<>();
        HashSet<Character> chars = new HashSet<>();

        while (l <= r && r < str.length()) {
            if (!chars.contains(str.charAt(r))) {
                len = Math.max(len, r - l + 1);
                chars.add(str.charAt(r++));
            } else {
                substrings.put(len, str.substring(l, r));
                len = 0;
                while (chars.contains(str.charAt(r)))
                    chars.remove(str.charAt(l++));
            }
        }

        for (int length : substrings.keySet()) {
            len = Math.max(len, length);
        }

        return substrings.get(len);
    }

    public static void main(String[] args) {
        String result = longestSubstring("abcabcdbb");

        System.out.println(result);
    }
}
