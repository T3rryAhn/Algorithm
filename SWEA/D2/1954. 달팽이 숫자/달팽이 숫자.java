
import java.util.Scanner;

public class Solution {
    // right, down, left, up        clock direction
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1}; // row가 내려가는 게 +1 하는 거니까 헷갈리지 말자

    // 다음 이동 좌표가 그래프 범위 이내인지 검사하는 메서드
    static boolean isInBound(int N, int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            // each case world~~~~~~~~~~~~
            int N = sc.nextInt();
            int graph[][] = new int[N][N];
            boolean isVisited[][] = new boolean[N][N];  // false로 초기화 되어있음.

            // 현재 위치, 다음 위치. 시작위치는 (0,0)
            int nowRow = 0;
            int nowCol = 0;
            int nextRow = 0;
            int nextCol = 0;

            // 첫위치 달팽이 배치 >> [0][0] 에 숫자 1 입력
            graph[0][0] = 1;
            isVisited[0][0] = true;

            for (int n = 2; n <= N * N; n++) {
                for(int i = 0; i < 4; i++) {
                    nextRow = nowRow + dr[i];
                    nextCol = nowCol + dc[i];

                    if(isInBound(N, nextRow, nextCol) && !isVisited[nextRow][nextCol]) {     //isVisited 를 isInBound 뒤로 써야 인덱스 범위 오류 안난다~~~
                        nowRow = nextRow;
                        nowCol = nextCol;
                        isVisited[nowRow][nowCol] = true;
                        graph[nowRow][nowCol] = n;
                        break;
                    }
                }
            }

            System.out.println("#" + caseNum);
            for (int[] row : graph) {
                for (int n : row) {
                    System.out.printf("%d ", n);
                }
                System.out.println();
            }
        }
    }
}
