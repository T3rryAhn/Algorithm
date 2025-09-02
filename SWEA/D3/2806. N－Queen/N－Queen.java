
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int[][] board;
    static int N;
    static int count;

    static int[] dr = {-1, -1, -1};
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_2806_NQueen\\sample_input (3).txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            count = 0;

            board = new int[N][N];
            setQueen(0);

            System.out.printf("#%d %d%n", tc, count);
            // case end
        }

    }

    static void setQueen(int row) {
        if(row == N){
            count++;
            return;
        }

        
        for(int c = 0; c < N; c++) {
            if(isValid(row, c)) {
                board[row][c] = 1;
                setQueen(row + 1);
                board[row][c] = 0;
            }
        }
    }

    static boolean isValid(int row, int col) {
        boolean result = true;

        for(int d = 0; d < 3; d++) {
            if(!result) break;

            int nextR = row + dr[d];
            int nextC = col + dc[d];

            while(isInBound(nextR, nextC)) {
                if(board[nextR][nextC] == 0) {
                    nextR += dr[d];
                    nextC += dc[d];
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    static boolean isInBound(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
