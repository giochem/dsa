import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] n = new int[100];
        for (int num : nums) {
            n[num]++;
        }
        List<Integer> sneaky = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            if (n[i] >= 2) {
                sneaky.add(i);
            }
        }
        return sneaky.stream().mapToInt(Integer::intValue).toArray();
    }
}