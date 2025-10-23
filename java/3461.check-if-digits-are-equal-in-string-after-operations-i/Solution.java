class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = (int) s.charAt(i);
        }

        int count = n - 2;
        while (count > 0) {
            for (int i = n - 1; i > 0; i--) {
                digits[i] = (digits[i] + digits[i - 1]) % 10;
            }
            count--;
        }
        if (digits[n - 1] == digits[n - 2]) {
            return true;
        }
        return false;
    }
}