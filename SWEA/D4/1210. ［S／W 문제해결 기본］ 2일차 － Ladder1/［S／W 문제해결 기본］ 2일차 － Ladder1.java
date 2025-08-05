import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            // each case world~~~~~~~~~~~~~~~~
            int caseNum = sc.nextInt();
            int[][] graph = new int[100][100];

            // 그래프 입력 받기
            for (int row = 0; row < 100; row++) {
                for (int col = 0; col < 100; col++) {
                    graph[row][col] = sc.nextInt();
                }
            }

            // parse start point
            int nowRow = -1;
            int nowCol = -1;

            for (int col = 0; col < graph.length; col++) {
                if (graph[graph.length - 1][col] == 2) {
                    nowRow = graph.length - 1;
                    nowCol = col;
                }
            }

            // follow ladder

            int dir = 2; // 0: 좌, 1: 우, 2: 위

            while (nowRow > 0) {
                if (dir != 1 && nowCol > 0 && graph[nowRow][nowCol - 1] == 1) {
                    // 왼쪽
                    nowCol--;
                    dir = 0;
                } else if (dir != 0 && nowCol < 99 && graph[nowRow][nowCol + 1] == 1) {
                    // 오른쪽
                    nowCol++;
                    dir = 1;
                } else {
                    // 위쪽
                    nowRow--;
                    dir = 2;
                }
            }

            System.out.printf("#%d %d%n", caseNum, nowCol);
        }

    }
}
