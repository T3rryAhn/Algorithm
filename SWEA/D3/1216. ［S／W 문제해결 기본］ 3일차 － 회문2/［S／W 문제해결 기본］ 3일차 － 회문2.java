

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    // 행 회문 검사기
    static boolean isPlainRow(char[][] graph, int len, int row, int col) {
        for (int i = 0; i < len / 2; i++) {
            if (graph[row][col + i] != graph[row][col + len - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // 열 회문 검사기
    static boolean isPlainCol(char[][] graph, int len, int row, int col) {
        for (int i = 0; i < len / 2; i++) {
            if (graph[row + i][col] != graph[row + len - 1 - i][col]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        for (int caseNum = 1; caseNum <= 10; caseNum++) {
            // each case world~~~~

            int T = sc.nextInt();
            char[][] graph = new char[100][100];
            int maxLen = 1;

            for (int i = 0; i < 100; i++) {
                graph[i] = sc.next().toCharArray();
            }

            boolean isPalinExist = false;
            for (int len = 100; len > 1; len--) {
                if (isPalinExist) {
                    break;
                }
                for (int row = 0; row < 100; row++) {
                    if (isPalinExist) {
                        break;
                    }
                    for (int col = 0; col < 100 - len + 1; col++) {
                        if (isPlainRow(graph, len, row, col)) {
                            maxLen = len;
                            isPalinExist = true;
                            break;
                        }
                    }
                }
            }

            isPalinExist = false;
            for (int len = 100; len > 1; len--) {
                if (isPalinExist) {
                    break;
                }
                for (int col = 0; col < 100; col++) {
                    if (isPalinExist) {
                        break;
                    }
                    for (int row = 0; row < 100 - len + 1; row++) {
                        if (isPlainCol(graph, len, row, col)) {
                            maxLen = maxLen > len ? maxLen : len;
                            isPalinExist = true;
                            break;
                        }
                    }
                }
            }

            System.out.printf("#%d %d%n", T, maxLen);
        }
    }
}
