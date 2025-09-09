//package _7465_창용마을무리의개수;

import java.io.*;
import java.util.*;

public class Solution {
    static int[] set;

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_7465_창용마을무리의개수\\s_input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            int n = sc.nextInt();
            int m = sc.nextInt();

            set = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                set[i] = i;
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                union(a, b);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(find(i), 0);
            }

            System.out.printf("#%d %d%n", tc, map.size());
            // case end
        }
        sc.close();
    }

    static void union(int a, int b) {
        set[find(b)] = find(a);
    }

    static int find(int a) {
        if (set[a] == a)
            return a;

        return set[a] = find(set[a]);
    }

}
