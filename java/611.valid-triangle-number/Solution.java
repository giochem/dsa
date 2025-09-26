import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int r = nums.length - 1; r >= 2; --r) {
            for (int l = 0; l <= r - 2; ++l) {
                int mid = l + 1;
                while (mid < r) {
                    if (nums[l] + nums[mid] > nums[r]) {
                        count += r - mid;
                        break;
                    }
                    mid++;
                }
            }
        }
        return count;
    }
}