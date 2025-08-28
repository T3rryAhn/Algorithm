

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            // case start
            // 9 8 7 6 5 4 3 2 1 0 num index
            // 0 0 0 0 0 0 0 0 0 0
            // 1 1 1 1 1 1 1 1 1 1 == 1024 - 1 == 1023
            int numCheckBit = 0;

            int N = sc.nextInt();
            int num = N;
            int count = 0;
            while (numCheckBit != 1023) {
                count++;
                num = count * N;
                String strN = String.valueOf(num);

                for (char c : strN.toCharArray()) {
                    switch (c) {
                        case '0':
                            numCheckBit |= (1 << 0);
                            break;
                        case '1':
                            numCheckBit |= (1 << 1);
                            break;
                        case '2':
                            numCheckBit |= (1 << 2);
                            break;
                        case '3':
                            numCheckBit |= (1 << 3);
                            break;
                        case '4':
                            numCheckBit |= (1 << 4);
                            break;
                        case '5':
                            numCheckBit |= (1 << 5);
                            break;
                        case '6':
                            numCheckBit |= (1 << 6);
                            break;
                        case '7':
                            numCheckBit |= (1 << 7);
                            break;
                        case '8':
                            numCheckBit |= (1 << 8);
                            break;
                        case '9':
                            numCheckBit |= (1 << 9);
                            break;
                    }

                }

                
            }

            System.out.printf("#%d %d%n", tc, num);
            // case end
        }
    }
}
