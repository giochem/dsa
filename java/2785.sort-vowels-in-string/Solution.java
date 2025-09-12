class Solution {
    public String sortVowels(String s) {
        // A, E, I, O, and U
        String strVowels = "AEIOUaeiou";
        String[] vowels = new String[10];
        for (int i = 0; i < vowels.length; i++) {
            vowels[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = strVowels.indexOf(ch);
            if (idx != -1) {
                vowels[idx] = vowels[idx] + ch;
            }
        }

        String newS = String.join("", vowels);
        int idxVowels = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = strVowels.indexOf(ch);
            if (idx != -1) {
                sb.setCharAt(i, newS.charAt(idxVowels));
                idxVowels += 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sortVowels("lEetcOde"));
    }
}