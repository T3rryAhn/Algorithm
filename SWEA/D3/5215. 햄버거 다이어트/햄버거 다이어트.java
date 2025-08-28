import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int L = sc.nextInt();

            int[][] items = new int[N][2];

            for (int i = 0; i < N; i++) {
                items[i][0] = sc.nextInt();
                items[i][1] = sc.nextInt();
            }

            int maxPoint = 0;

            // n-1 n-2 ...             2 1 0           재료 인덱스 n개
            // 0 0 0 0 0 0 0 0 0 0 0 0 0 0             0은 사용안함, 1은 사용함
            // 1 1 1 1 1 1 1 1 1 1 1 1 1 1
            for (int i = 0; i < (1 << N); i++) { // N 만큼 미뤄야 n + 1개의 자리수이고 그전까지니까 1이 n개 까지 있는 숫자까지감
                // 여기서의 i는 모든 재료의 경우의수 하나하나의 케이스임
                int point = 0;
                int kcal = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        point += items[j][0];
                        kcal += items[j][1];
                    }
                }

                if (kcal <= L) {
                    maxPoint = Math.max(maxPoint, point);
                }
            }

            System.out.printf("#%d %d%n", tc, maxPoint);
        }

    }
}
