//package _7733_치즈도둑;

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] cheese;
    static boolean[][] visited;
    static boolean[][] dayVisited;  // this is for record fairy eatten

    // 4 ways. up down left right
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_7733_치즈도둑\\input (1).txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            cheese = new int[N][N];
            dayVisited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    cheese[r][c] = sc.nextInt();
                }
            }

            int maxPiece = 0;
            for (int day = 0; day <= 100; day++) {
                // day world start
                int pieceCnt = 0;

                // fairy eats cheese. i never allowed it
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (cheese[r][c] == day) {
                            dayVisited[r][c] = true;
                        }
                    }
                }

                visited = new boolean[N][];
                for(int i = 0; i < N; i++) {
                    visited[i] = Arrays.copyOf(dayVisited[i], N);
                }

                // count piece
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (!visited[r][c]) {
                            bfs(r, c);
                            pieceCnt++;
                        }
                    }
                }

                maxPiece = Math.max(maxPiece, pieceCnt);
                // day end
            }

            System.out.printf("#%d %d%n", tc, maxPiece);
            // case end
        }
        sc.close();
    }// main

    static boolean isInBound(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] { r, c });
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(isInBound(nr, nc) && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }
}
