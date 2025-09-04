
import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int X;
    static int M;
    static int[] cages;
    static int[][] query;
    static List<int[]> answers;
    static int hamsterCnt;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            X = sc.nextInt();
            M = sc.nextInt();

            cages = new int[N + 1];
            query = new int[M][3];
            answers = new ArrayList<>();
            hamsterCnt = -1;

            for (int i = 0; i < M; i++) {
                query[i][0] = sc.nextInt();
                query[i][1] = sc.nextInt();
                query[i][2] = sc.nextInt();
            }

            dfs(1);

            StringBuilder sb = new StringBuilder();

            if (answers.isEmpty()) {
                sb.append(-1);
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(answers.get(0)[i] + " ");
                }
            }

            System.out.printf("#%d %s%n", tc, sb);

            // for(int[] a : answers) {
            // System.out.println(Arrays.toString(a));
            // }
            // case end
        }

    }

    static void dfs(int idx) {
        if (idx == N + 1) {
            // System.out.println(Arrays.toString(cages));
            if (checkQuery()) {
                int sum = 0;
                for (int n : cages) {
                    sum += n;
                }
                if (sum > hamsterCnt) {
                    hamsterCnt = sum;
                    answers.clear();
                    answers.add(Arrays.copyOf(cages, cages.length));
                }
            }
            return;
        }

        for (int n = 0; n <= X; n++) {
            cages[idx] = n;
            dfs(idx + 1);
        }
    }

    static boolean checkQuery() {
        for (int[] q : query) {
            int sum = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                sum += cages[i];
            }
            if (sum != q[2]) {
                return false;
            }
        }
        return true;
    }
}
