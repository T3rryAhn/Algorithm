

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static boolean isPalinRow(char[][] graph, int len, int row, int col) {
        for (int i = 0; i < len / 2; i++) {

            if (graph[row][col + i] != graph[row][col + len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalinCol(char[][] graph, int len, int row, int col) {
        for (int i = 0; i < len / 2; i++) {

            if (graph[row + i][col] != graph[row + len - 1 - i][col]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("playground\\_1215_회문1\\input.txt");
        Scanner sc = new Scanner(System.in);
		
        for (int caseNum = 1; caseNum <= 10; caseNum++) {
            // each case world~~~
            char[][] graph = new char[8][8];
            int palindromeLen = sc.nextInt();
            int count = 0;

            for (int i = 0; i < 8; i++) {
                graph[i] = sc.next().toCharArray();
            }

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col <= 8 - palindromeLen; col++) {
                    if (isPalinRow(graph, palindromeLen, row, col)) {
                        count++;
                    }
                }
            }

            // 2) 세로 검사: 모든 col(0~7), row는 palLen 넓이만큼만
            for (int row = 0; row <= 8 - palindromeLen; row++) {
                for (int col = 0; col < 8; col++) {
                    if (isPalinCol(graph, palindromeLen, row, col)) {
                        count++;
                    }
                }
            }

            System.out.printf("#%d %d%n", caseNum, count);
        }

    }
}
