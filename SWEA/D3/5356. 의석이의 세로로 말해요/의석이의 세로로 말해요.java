import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_5356_의석이넌나가라\\sample_input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            // each case world~~~
            int maxLen = 0;
            String result = "";
            String[] inputStr = new String[5];
            for (int i = 0; i < 5; i++) {
                inputStr[i]= sc.next();
                maxLen = maxLen > inputStr[i].length() ? maxLen : inputStr[i].length();
            }

            for (int col = 0; col < maxLen; col++) {
                for (int row = 0; row < 5; row++) {
                    if( col >= inputStr[row].length()) {
                        continue;
                    }
                    result += inputStr[row].charAt(col);
                }
            }

            System.out.printf("#%d %s%n", caseNum, result);
        }
    }
}