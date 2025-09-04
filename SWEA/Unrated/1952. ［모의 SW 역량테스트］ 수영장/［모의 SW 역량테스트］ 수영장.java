
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            int[] months = new int[12 + 1];
            int[] dp = new int[12 + 1];
            int[] fees = new int[4];

            for (int i = 0; i < 4; i++) {
                fees[i] = sc.nextInt();
            }

            for (int i = 1; i <= 12; i++) {
                months[i] = sc.nextInt();
            }

            // dp[n] = min(min(1일권/1달권) + dp[i - 1], 3개월권 + dp[n - 3])
            // n월의 최소 비용은 이전달까지 비용 + 이번달 최선 또는 3달전 비용 + 3개월치 중 최솟값
            dp[0] = 0;
            dp[1] = Math.min(Math.min(fees[0] * months[1], fees[1]) + dp[0], fees[2]);
            dp[2] = Math.min(Math.min(fees[0] * months[2], fees[1]) + dp[1], fees[2]);

            for(int n = 3; n <= 12; n++) {
                dp[n] = Math.min(Math.min(fees[0] * months[n], fees[1]) + dp[n - 1], fees[2] + dp[n - 3]);
            }

            int result = fees[3] > dp[12] ? dp[12] : fees[3];
            System.out.println("#" + tc + " " + result);
            // case end
        }
    }
}
