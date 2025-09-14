

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N;
    static int count;

    // [0 ..  9] : 열 사용
    // [10.. 29] : \ 대각 (r - c + (N-1))
    // [30.. 49] : / 대각 (r + c)
    static final int COL_BASE  = 0;
    static final int D1_BASE   = 10;
    static final int D2_BASE   = 30;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            count = 0;

            bfs();

            System.out.println("#" + tc + " " + count);
        }
    }

    static void bfs() {
        Queue<long[]> q = new ArrayDeque<>();

        for (int c = 0; c < N; c++) {
            long bits = 0L;
            bits = markPosOnBit(0, c, bits);        // 0행 c열에 퀸을 둠(열/대각 비트 세팅)
            q.add(new long[]{0, c, bits});          // {현재 행, 현재 열, 누적 비트}
        }

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            int cr = (int) curr[0];
            long used = curr[2];

            // 마지막 행까지 배치 완료
            if (cr == N - 1) {
                count++;
                continue;
            }

            int nr = cr + 1; // 다음 행
            for (int nc = 0; nc < N; nc++) {
                if (checkPosByBit(nr, nc, used)) {
                    long nb = markPosOnBit(nr, nc, used);
                    q.add(new long[]{nr, nc, nb});
                }
            }
        }
    }

    static long markPosOnBit(int r, int c, long bits) {
        bits |= (1L << (COL_BASE + c));

        int d1 = r - c + (N - 1); // 0..2N-2
        int d2 = r + c;           // 0..2N-2
        bits |= (1L << (D1_BASE + d1));
        bits |= (1L << (D2_BASE + d2));
        return bits;
    }

    static boolean checkPosByBit(int r, int c, long bits) {
        long query = 0L;

        // 열 충돌 검사
        query |= (1L << (COL_BASE + c));

        // 대각 충돌 검사
        int d1 = r - c + (N - 1);
        int d2 = r + c;
        query |= (1L << (D1_BASE + d1));
        query |= (1L << (D2_BASE + d2));

        return (bits & query) == 0L;
    }
}
