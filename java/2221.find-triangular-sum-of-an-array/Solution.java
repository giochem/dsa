class Solution {
    public int triangularSum(int[] nums) {
        // loop nums.length - 1 times
        for (int l = 0; l < nums.length - 1; l++) {
            for (int i = 0; i < nums.length - l - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}