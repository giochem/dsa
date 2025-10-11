import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://usaco.guide/bronze/casework#problem-usaco-567
public class Solution {
    public static void main(String[] args) throws IOException {
        // File input and output
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter("paint.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int covered = 0;
        if (b <= c || a >= d) {
            covered = b - a + d - c;
        } else {
            covered = Math.max(b, d) - Math.min(a, c);
        }
        pw.println(covered);
        br.close();
        pw.close();
    }
}
