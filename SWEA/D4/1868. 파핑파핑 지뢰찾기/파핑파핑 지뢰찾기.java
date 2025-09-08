//package _1868_파핑파핑;

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] originTable;
    static int[][] table;
    static boolean[][] visited;

    // 8 way left-up, up, right-up, left, right, left-down, down, right-down
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_1868_파핑파핑\\input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            table = new int[N][N];
            originTable = new char[N][N];
            visited = new boolean[N][N];

            // input
            for (int r = 0; r < N; r++) {
                String row = sc.next();
                for (int c = 0; c < N; c++) {
                    originTable[r][c] = row.charAt(c);
                }
            }

            // make calculated table
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    char tmp = originTable[r][c];

                    // if bomb
                    if (tmp == '*') {
                        visited[r][c] = true;
                        table[r][c] = -1;
                        continue;
                    }

                    // not bomb cell. then mark bombcnt
                    int bombCnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (isInBound(nr, nc)) {
                            if (originTable[nr][nc] == '*') {
                                bombCnt++;
                            }
                        }
                    }
                    table[r][c] = bombCnt;
                }
            }

            int clickCnt = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (table[r][c] == 0 && !visited[r][c]) {
                        bfs(r, c);
                        clickCnt++;
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (table[r][c] > 0 && !visited[r][c]) {
                        bfs(r, c);
                        clickCnt++;
                    }
                }
            }

            System.out.printf("#%d %d%n", tc, clickCnt);

            // case end
        }
        sc.close();

    } // main

    static boolean isInBound(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void bfs(int r, int c) {
        Queue<int[]> bfsQueue = new ArrayDeque<>();

        bfsQueue.add(new int[] { r, c });

        while (!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            int cr = curr[0];
            int cc = curr[1];

            visited[cr][cc] = true;
            if (table[cr][cc] != 0)
                continue;

            for (int d = 0; d < 8; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (isInBound(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    if (table[nr][nc] == 0) {
                        bfsQueue.add(new int[] { nr, nc });
                    }
                }
            } // for
        } // while
    }// bfs
}
