
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mex = new int[value];
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                nums[i] += -1 * (nums[i] / value) * value + value;
            }
            mex[nums[i] % value]++;
        }
        int idx = 0;
        int min = mex[0];
        for (int i = 0; i < mex.length; i++) {
            if (min > mex[i]) {
                min = mex[i];
                idx = i;
            }
        }
        System.out.println(min + "-" + idx);
        if (min == 0) {
            return idx;
        }
        return min * value + idx;
    }
}