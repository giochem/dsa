import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // File input and output
        File file = new File("breedflip.in");
        Scanner sc = new Scanner(file);
        PrintWriter pw = new PrintWriter("breedflip.out");
        int n = Integer.parseInt(sc.nextLine());
        String a = sc.nextLine();
        String b = sc.nextLine();

        int count = 0;
        boolean diff = false;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!diff) {
                    count++;
                    diff = true;
                }
                continue;
            }
            diff = false;
        }
        pw.print(count);
        pw.close();
        sc.close();
    }
}
