//package _7733_치즈도둑;

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] cheese;
    static int[][] visited;

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
            visited = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    cheese[r][c] = sc.nextInt();
                }
            }

            int maxPiece = 1;
            for (int day = 1; day <= 100; day++) {
                // day world start
                int pieceCnt = 0;

                // fairy eats cheese. i never allowed it
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (cheese[r][c] == day) {
                            visited[r][c] = day;
                        }
                    }
                }

                // count piece
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (visited[r][c] < day && cheese[r][c] > day) {
                            bfs(r, c, day);
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

    static void bfs(int r, int c, int day) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] { r, c });
        visited[r][c] = day;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(isInBound(nr, nc) && visited[nr][nc] < day && cheese[nr][nc] > day) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = day;
                }
            }
        }

    }
}
