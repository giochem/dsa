class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] englishLetters = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            englishLetters[(int) brokenLetters.charAt(i) - 97] = true;
        }
        int count = 0;
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            if (newWord == false) {
                if (text.charAt(i) == ' ') {
                    newWord = true;
                }
                continue;
            }
            if (text.charAt(i) == ' ') {
                count++;
                continue;
            }
            if (englishLetters[(int) text.charAt(i) - 97]) {
                newWord = false;
            } else {
                continue;
            }
        }
        if (newWord == true) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // System.out.println(sol.canBeTypedWords("hello word", "ad"));
        System.out.println(sol.canBeTypedWords("leet code", "lt"));
    }
}