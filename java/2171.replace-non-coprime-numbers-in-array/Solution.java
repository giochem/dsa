import java.util.*;

class Solution {
    public int findGCD(int a, int b) {
        int divided = a >= b ? a : b;
        int mod = a >= b ? b : a;
        while (divided % mod != 0) {
            int tmp = divided % mod;
            divided = mod;
            mod = tmp;
        }
        return mod;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        // LCM(a, b) = (a * b) / GCD(a, b)
        List<Integer> coprime = new ArrayList<>();
        coprime.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num1 = coprime.get(coprime.size() - 1);
            int num2 = nums[i];
            int gcd = findGCD(num1, num2);

            if (gcd != 1) {
                int lcm = (num1 / gcd * num2);
                coprime.removeLast();

                coprime.add(lcm);

                // loop in list
                while (coprime.size() >= 2) {
                    num1 = coprime.get(coprime.size() - 2);
                    num2 = coprime.getLast();
                    gcd = findGCD(num1, num2);

                    if (gcd != 1) {
                        lcm = (num1 * num2) / gcd;

                        coprime.removeLast();
                        coprime.removeLast();
                        coprime.add(lcm);
                    } else {
                        break;
                    }
                }
            } else {
                coprime.add(num2);
            }
        }
        return coprime;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[] {
                2, 2, 1, 1, 3, 3, 3
        };
        int[] arr2 = new int[] {
                31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561
        };
        int[] arr3 = new int[] {
                8303, 361, 8303, 361, 437, 361, 8303, 8303, 8303, 6859, 19, 19, 361, 70121, 70121, 70121, 70121, 70121,
                70121, 70121, 70121, 70121, 70121, 70121, 70121, 70121, 70121, 70121, 70121, 1271, 31, 961, 31, 7, 2009,
                7, 2009, 2009, 49, 7, 7, 8897, 1519, 31, 1519, 217
        };
        // System.out.println(sol.replaceNonCoprimes(arr));
        // System.out.println(sol.replaceNonCoprimes(arr2));
        System.out.println(sol.replaceNonCoprimes(arr3));
    }
}