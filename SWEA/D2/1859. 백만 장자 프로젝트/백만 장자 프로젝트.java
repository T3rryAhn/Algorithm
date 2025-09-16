

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("src\\swea\\_1859_백만장자\\input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // long result = 0;
            // for(int i = 0; i < N; i++) {
            // int max = 0;
            // for(int j = i; j < N; j++) {
            // max = Math.max(max, arr[j]);
            // }
            // if(max > arr[i]) {
            // result += max - arr[i];
            // }
            // }

            long result = 0L;
            int maxPrice = arr[N-1];
            for (int i = N - 2; i >= 0; i--) {
                // 거꾸로 탐색
                int currPrice = arr[i];

                if(currPrice > maxPrice) {
                    maxPrice = currPrice;
                }
                else if (currPrice < maxPrice) {
                    result += maxPrice - currPrice;
                }

            }

            System.out.printf("#%d %d%n", tc, result);
        }
    }
}
