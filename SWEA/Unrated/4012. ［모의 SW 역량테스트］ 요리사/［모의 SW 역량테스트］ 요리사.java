

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[][] table;
    static int N;
    static int minPoint;

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("playground\\_4012_요리사\\sample_input (2).txt");
        //Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            N = sc.nextInt();
            table = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    table[row][col] = sc.nextInt();
                }
            }

            minPoint = Integer.MAX_VALUE;

            selectItems(new ArrayList<Integer>(), 0, 0);

            System.out.println("#"+tc+" "+minPoint);
            // case end
        }

    }

    static void selectItems(List<Integer> foodA, int idx, int foodAcheckBit) {
        // 종료.
        if(foodA.size() == N / 2) {
            List<Integer> foodB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if((foodAcheckBit & (1 << i)) != 0)
                    continue;
                foodB.add(i);
            }

            int foodAPoint =0;
            for (int n : foodA) {
                for (int j : foodA) {
                    if (n == j) continue;

                    foodAPoint += table[n][j];
                }
            }
            int foodBPoint =0;
            for (int n : foodB) {
                for (int j : foodB) {
                    if (n == j) continue;

                    foodBPoint += table[n][j];
                }
            }

            minPoint = Math.min(minPoint, Math.abs(foodAPoint - foodBPoint));

            return;
        }

        if(idx == N)
            return;

        // 재료[idx] 뽑았을경우
        foodAcheckBit |= (1 << idx);
        foodA.add(idx);
        selectItems(foodA, idx + 1, foodAcheckBit);

        // 재료[idx] 안뽑았을 경우
        foodAcheckBit ^= (1 << idx);
        foodA.remove(foodA.size() - 1);
        selectItems(foodA, idx + 1, foodAcheckBit);
    }

}
