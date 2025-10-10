class Solution {
    public int maximumEnergy(int[] energy, int k) {
        for (int i = energy.length - 1 - k; i >= 0; i--) {
            energy[i] += energy[i + k];
        }
        int maxEnergy = energy[0];
        for (int i = 1; i < energy.length; i++) {
            if (energy[i] > maxEnergy) {
                maxEnergy = energy[i];
            }
        }
        return maxEnergy;
    }
}