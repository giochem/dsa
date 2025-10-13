import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (res.isEmpty() || !anagram(res.get(res.size() - 1), words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    public boolean anagram(String a, String b) {
        char[] aChars = a.toCharArray();
        Arrays.sort(aChars);
        String aSort = new String(aChars);

        char[] bChars = b.toCharArray();
        Arrays.sort(bChars);
        String bSort = new String(bChars);

        if (aSort.equals(bSort)) {
            return true;
        }
        return false;
    }
}