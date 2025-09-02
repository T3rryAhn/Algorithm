

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int winCount;
    static int loseCount;
    static int[] cards = new int[9];

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_6808_규영이와인영이의카드게임\\s_input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            winCount = 0;
            loseCount = 0;

            // 18 17 . . . 3 2 1
            // 17 16 . . . 2 1 0
            // 0 0 . . . . 0 0 0
            int visited = 0;
            for (int i = 0; i < 9; i++) {
                int tmp = sc.nextInt();
                cards[i] = tmp;
                visited |= (1 << (tmp - 1)); // 0 번자리부터 1임.
            }

            purmutation(0, 0, visited, 0);

            System.out.printf("#%d %d %d%n", tc, winCount, loseCount);
            // case end
        }
    }

    /*
     * count playerK win
     */
    static void purmutation(int playerK, int playerI, int visited, int round) {
        // end
        if (round == 9) {
            if(playerK > playerI) {
                winCount++;
            } else {
                loseCount++;
            }
            return;
        }

        for (int i = 0; i < 18; i++) {
            if((visited & (1 << i)) != 0) continue;

            int nextVisited = visited | (1 << i);
            // player kyu yong win round
            if(cards[round] > i + 1) {
                purmutation(playerK + cards[round] + i + 1, playerI, nextVisited, round + 1);
            }
            // player In yong win round
            else {
                purmutation(playerK, playerI + cards[round] + i + 1, nextVisited, round + 1);
            }
        }
    }

}
