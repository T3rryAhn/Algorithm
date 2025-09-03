
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("./playground/_14510_나무높이/Sample_input (1).txt");
        //Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            // case start
            int N = sc.nextInt();
            int[] trees = new int[N];
            int maxH = 0;

            for(int i = 0; i < N; i++) {
                trees[i] = sc.nextInt();
                maxH = Math.max(maxH, trees[i]);
            }

            int odds = 0;
            int evens = 0;
            for(int tree : trees) {
                int height = maxH - tree;
                if (height == 0) {
                    continue;
                }
                else if(height % 2 != 0) {
                    odds++;
                    evens += height / 2;
                } else {
                    evens += height / 2;
                }
            }

            int day = 0;

            while(!(odds == 0 && evens == 0)) {
                day++;

                if (day % 2 == 1) {
                    if(odds > 0) {
                        odds--;
                    }  else if(evens != 1){
                        odds++;
                        evens--;
                    }
                } else {
                    if(evens > 0) {
                        evens--;
                    }
                }

                
            }

            System.out.printf("#%d %d%n", tc, day);
            // case end
        }
    }
}
