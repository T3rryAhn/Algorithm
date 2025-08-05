import java.util.Scanner;

public class Solution {
    static int[] dc = { -1, 1, 0 }; // left, right, up
    static int[] dr = { 0, 0, -1 };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            // each case world~~~~~~~~~~~~~~~~
            int caseNum = sc.nextInt();
            int[][] graph = new int[100][100];
            boolean[][] visited = new boolean[100][100];

            // 그래프 입력 받기
            for (int row = 0; row < 100; row++) {
                for (int col = 0; col < 100; col++) {
                    graph[row][col] = sc.nextInt();
                }
            }

            // parse start point
            int nowRow = -1;
            int nowCol = -1;
            int nextRow = -1;
            int nextCol = -1;

            for (int col = 0; col < graph.length; col++) {
                if (graph[graph.length - 1][col] == 2) {
                    nowRow = graph.length - 1;
                    nowCol = col;
                }
            }

            // follow ladder
            while (nowRow != 0) { // 0행에 도착하면 반복 중지
                // try move 3 direction
                for (int d = 0; d < 3; d++) {
                    nextRow = nowRow + dr[d];
                    nextCol = nowCol + dc[d];

                    if (nextCol >= 0 && nextCol < graph.length && graph[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        nowRow = nextRow;
                        nowCol = nextCol;
                        visited[nowRow][nowCol] = true;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d%n", caseNum, nowCol);
        }

    }
}
