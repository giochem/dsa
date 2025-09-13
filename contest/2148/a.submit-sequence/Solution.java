import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int n = scanner.nextInt();

            if (n % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(x);
            }
        }
        scanner.close();

    }
}