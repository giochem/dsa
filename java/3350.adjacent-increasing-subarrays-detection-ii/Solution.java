import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int k = 1;
        int count1 = 1;
        int count2 = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                count1++;
                if (count1 <= count2) {
                    k = Math.max(k, count1);
                }
            } else {
                k = Math.max(k, count1 / 2);
                count2 = count1;
                count1 = 1;
            }
        }
        k = Math.max(k, count1 / 2);
        return k;
    }
    // 1 2 3 4 5 0 1 2 3 4 5 6
}