import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            // each case world
            int caseNum = sc.nextInt();
            int[][] matrix = new int[100][100];

            // set metrix by input
            for (int row = 0; row < 100; row++) {
                for (int col = 0; col < 100; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int sum = 0;
            int result = 0;
            // 행 덧셈
            for (int[] arr : matrix) {
                for (int n : arr) {
                    sum += n;
                }
                result = sum > result ? sum : result;
                sum = 0;
            }

            // 열 합
            for (int col = 0; col < matrix[0].length; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    sum += matrix[row][col];
                }
                result = sum > result ? sum : result;
                sum = 0;
            }

            // 대각선 오 아래
            for (int i = 0; i < 100; i++) {
                sum += matrix[i][i];
            }
            result = sum > result ? sum : result;
            sum = 0;
            // 대각선 왼 아래

            for (int i = 0; i < 100; i++) {
                sum += matrix[i][matrix.length - 1 - i];
            }
            result = sum > result ? sum : result;

            System.out.printf("#%d %d%n", caseNum, result);
        }
    }
}
