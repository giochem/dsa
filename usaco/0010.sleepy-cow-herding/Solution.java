import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        // File input and output
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter("herding.out");

        // Read in the positions of the three cows, cow1, cow2, and cow3
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cow1 = Integer.parseInt(st.nextToken());
        int cow2 = Integer.parseInt(st.nextToken());
        int cow3 = Integer.parseInt(st.nextToken());

        // Sort the three positions in order, this will make computation easier.
        int temp;
        if (cow1 > cow3) {
            temp = cow3;
            cow3 = cow1;
            cow1 = temp;
        }
        if (cow2 > cow3) {
            temp = cow3;
            cow3 = cow2;
            cow2 = temp;
        }
        if (cow1 > cow2) {
            temp = cow2;
            cow2 = cow1;
            cow2 = temp;
        }

        int min;
        if (cow1 + 1 == cow2 && cow2 + 1 == cow3) {
            min = 0;
        } else if (cow1 + 2 == cow2 || cow2 + 2 == cow3) {
            min = 1;
        } else {
            min = 2;
        }
        int max = Math.max(cow2 - cow1, cow3 - cow2) - 1;

        pw.println(min);
        pw.println(max);
        br.close();
        pw.close();
    }
}
