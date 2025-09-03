
import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] edge;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start

            N = sc.nextInt();
            int M = sc.nextInt();

            edge = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                edge[a][b] = 1;
                edge[b][a] = 1;
            }

            int count = bfs(1);
            

            System.out.printf("#%d %d%n", tc, count);

            // case end
        }
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;

        queue.add(new int[] { start, 0 });
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int nextIdx = next[0];
            int dept = next[1];
            visited[nextIdx] = true;
            
            if (dept == 2) continue;

            for (int i = 1; i <= N; i++) {
                if (edge[nextIdx][i] == 1 && !visited[i]) {
                    queue.add(new int[] { i, dept + 1 });
                }
            }
        }

        for(boolean b : visited) {
            if (b) {
                count ++;
            }
        }
        count--; // 1번 제외
        // System.out.println(Arrays.toString(visited));
        return count;
    }
}
