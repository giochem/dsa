class Solution {
    public boolean validSelections(int[] nums, int i, int dir) {
        int[] numsCopy = nums.clone();

        boolean valid = true;
        while (valid) {
            i += dir;
            if (i < 0 || i > numsCopy.length - 1) {
                break;
            } else if (numsCopy[i] == 0) {
                continue;
            } else {
                numsCopy[i] = numsCopy[i] - 1;
                dir = -dir;
            }
        }
        int sum = 0;
        for (int n : numsCopy) {
            sum += n;
        }
        return sum == 0 ? true : false;
    }

    public int countValidSelections(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (validSelections(nums, i, 1)) {
                    c++;
                }
                if (validSelections(nums, i, -1)) {
                    c++;
                }
            }
        }
        return c;
    }
}