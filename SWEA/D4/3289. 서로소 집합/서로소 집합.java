
import java.io.*;
import java.util.*;

public class Solution {
    static int[] set = new int[1_000_000 + 1];
    
    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_3289_서로소집합\\sample_input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            
            sb.setLength(0);
            sb.append("#" + tc + " ");
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            for(int i = 0; i <= N; i++) {
                set[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int command = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                switch (command) {
                    case 0:
                        union(a, b);
                        break;
                
                    case 1:
                        int result = find(a) == find(b) ? 1 : 0;
                        sb.append(result);
                        break;
                }
            }

            System.out.println(sb);

            // case end
        }
        sc.close();
    }// main

    static void union(int a, int b) {
        set[find(b)] = find(a);
    }

    static int find(int a) {
        if (set[a] == a) {
            return a;
        }

        return set[a] = find(set[a]);
    }
}
