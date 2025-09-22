class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frequencies = new int[100];
        int maxFre = 0;
        int totalFrequency = 0;
        for (int i = 0; i < nums.length; ++i) {
            frequencies[nums[i] - 1]++;
            maxFre = Math.max(maxFre, frequencies[nums[i] - 1]);
        }
        for (int i = 0; i < frequencies.length; ++i) {
            if (maxFre == frequencies[i]) {
                totalFrequency += maxFre;
            }
        }
        return totalFrequency;
    }
}