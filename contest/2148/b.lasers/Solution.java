import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read the number of test cases
        int t = Integer.parseInt(br.readLine());

        // Loop for each test case
        while (t-- > 0) {
            // Read the first line of the test case: n, m, x, y
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
            }

            // Read the m vertical laser coordinates
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = Integer.parseInt(st.nextToken());
            }
            System.out.println(n + m);
        }
    }
}