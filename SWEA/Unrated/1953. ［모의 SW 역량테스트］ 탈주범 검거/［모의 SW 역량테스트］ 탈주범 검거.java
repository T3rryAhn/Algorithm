//package playground._1953_탈주범검거;

import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, R, C, L;
    static int[][] graph;
    static boolean[][] visited;

    // 4ways. up, down, left, right
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    // reverse ways. for check connection
    // down, up, right, left
    static int[] opposite = { 1, 0, 3, 2 };

    // pipe directions
    // 1 indexing. 1, 2, 3, 4 ..., 7
    static int[][] pipe = {
            {}, // 0
            { 0, 1, 2, 3 }, // 1
            { 0, 1 }, // 2
            { 2, 3 }, // 3
            { 0, 3 }, // 4
            { 1, 3 }, // 5
            { 1, 2 }, // 6
            { 0, 2 } // 7
    };

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("playground\\_1953_탈주범검거\\sample_input (5).txt");
        //Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            L = sc.nextInt();

            graph = new int[N][M];
            visited = new boolean[N][M];

            // fill graph. visited check walls
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int tmp = sc.nextInt();
                    graph[r][c] = tmp;
                    if (tmp == 0) {
                        visited[r][c] = true;
                    }
                }
            }

            int answer = bfs(R, C);
            System.out.printf("#%d %d%n", tc, answer);
            // case end
        }
        sc.close();
    } // main

    private static boolean isInBound(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static boolean isConnected(int preDirecton, int pipeType) {
        int target = opposite[preDirecton];
        for (int p : pipe[pipeType]) {
            if (target == p)
                return true;
        }
        return false;
    }

    private static int bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        // add start point
        q.add(new int[] { r, c });
        visited[r][c] = true;

        int count = 0;
        int hour = 0;
        while (!q.isEmpty() && hour < L) {
            // group by dept
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] curr = q.poll();
                int cr = curr[0];
                int cc = curr[1];
                count++;

                int[] dir = pipe[graph[cr][cc]];
                for (int d = 0; d < dir.length; d++) {
                    int nr = cr + dr[dir[d]];
                    int nc = cc + dc[dir[d]];

                    if(isInBound(nr, nc) && !visited[nr][nc] && isConnected(dir[d], graph[nr][nc])) {
                        q.add(new int[] { nr, nc });
                        visited[nr][nc] = true;
                    }
                }
            } // for q
            hour++;
        } // while

        return count;
    }
}
