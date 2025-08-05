import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            // each case world~~~~~
            int[] boxes = new int[100];
            int dumpCount = sc.nextInt();

            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = sc.nextInt();
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int n : boxes) {
                min = min < n ? min : n;
                max = max > n ? max : n;
            }

            int[] count = new int[max + 1]; // + 1은 인덱스랑 value랑 일치 시키려고
            for (int i : boxes) {
                count[i]++;
            }

            int minPoint = 0;
            int maxPoint = max;
            while (dumpCount >= 0) {
                if (count[maxPoint] == 0) {
                    maxPoint--;
                    continue;
                }
                if (count[minPoint] == 0) {
                    minPoint++;
                    continue;
                }

                count[maxPoint]--;
                count[minPoint]--;
                count[maxPoint - 1]++;
                count[minPoint + 1]++;
                dumpCount--;
            }

            System.out.printf("#%d %d%n", test_case, (maxPoint - minPoint));
        }
    }
}
