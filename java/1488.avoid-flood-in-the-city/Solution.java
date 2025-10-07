import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> full = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (full.get(rains[i]) == null) {
                    full.put(rains[i], i);
                } else {
                    boolean dry = false;
                    for (int j = full.get(rains[i]); j < i; j++) {
                        if (rains[j] == 0) {
                            rains[j] = rains[i];
                            full.put(rains[i], i);
                            dry = true;
                            break;
                        }
                    }
                    if (dry == false) {
                        return new int[0];
                    }
                }
                rains[i] = -1;
            }
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                rains[i] = 1;
            }
        }
        return rains;
    }
}