import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = k - 1; i <= nums.size() - k - 1; i++) {
            int l = i;
            boolean lIncrea = true;
            for (int li = l - 1; li >= l + 1 - k; li--) {
                if (nums.get(li) >= nums.get(li + 1)) {
                    lIncrea = false;
                    break;
                }
            }
            if (!lIncrea) {
                continue;
            }
            int r = i + 1;
            boolean rIncrea = true;
            for (int ri = r + 1; ri <= r + k - 1; ri++) {
                if (nums.get(ri - 1) >= nums.get(ri)) {
                    rIncrea = false;
                    break;
                }
            }
            if (rIncrea) {
                return true;
            }
        }
        return false;
    }
}