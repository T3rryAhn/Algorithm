import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // testcase 10개 고정
        for (int T = 0; T < 10; T++) {
            // testcase world

            // Input
            int N = sc.nextInt();
            int count = 0;

            int[] buildings = new int[N];
            for (int i = 0; i < buildings.length; i++) {
                buildings[i] = sc.nextInt();
            }

            // buildings 배열 순회
            for (int i = 2; i < buildings.length - 2; i++) {

                int left = Math.min((buildings[i] - buildings[i - 2]), (buildings[i] - buildings[i - 1]));
                int right = Math.min((buildings[i] - buildings[i + 1]), (buildings[i] - buildings[i + 2]));
                int total = Math.min(left, right);
                if (total > 0) {
                    count += total;
                }
            }
            System.out.printf("#%d %d%n", (T + 1), count);
        }
    }
}
