import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        int t = Integer.parseInt(br.readLine());

        // Loop through each test case
        while (t-- > 0) {
            // Read n and m
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            // Arrays to store a and b
            int[] a = new int[n];
            int[] b = new int[n];

            // Read the n requirements
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
            }
            int side = 0;
            int point = 0;
            int time = 0;
            for (int i = 0; i < n; i++) {
                if (side != b[i]) {
                    point++;
                    point += 2 * ((a[i] - (time + 1)) / 2);
                    time = a[i];
                    side = b[i];
                } else {
                    point += 2 * ((a[i] - time) / 2);
                    time = a[i];
                    side = b[i];
                }
            }
            point += (m - time);
            System.out.println(point);

            // Now you have n, m, array a, and array b for this test case.
            // You can implement your solution logic here.

            // Example of printing the values to verify
            // System.out.println("n: " + n + ", m: " + m);
            // System.out.print("a: ");
            // for (int val : a) {
            // System.out.print(val + " ");
            // }
            // System.out.println();
            // System.out.print("b: ");
            // for (int val : b) {
            // System.out.print(val + " ");
            // }
            // System.out.println();
        }
    }
}