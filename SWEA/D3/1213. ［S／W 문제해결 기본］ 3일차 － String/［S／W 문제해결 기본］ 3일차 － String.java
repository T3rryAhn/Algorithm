import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("playground\\_1213_string\\test_input.txt");
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(file);

        for (int caseNum = 0; caseNum < 10; caseNum++) {
            int tc = sc.nextInt();
            sc.nextLine();
            String target = sc.nextLine();
            String str = sc.nextLine();

            int count = 0;
            for (int i = 0; i < str.length() - target.length() + 1; i++) {
                boolean iFindIt = true;
                for (int j = 0; j < target.length(); j++) {
                    if (target.charAt(j) != str.charAt(i + j)) {
                        iFindIt = false;
                        break;
                    }
                }
                if (iFindIt) {
                    count++;
                    iFindIt = false;
                }
            }
            
            System.out.printf("#%d %d%n", tc, count);
        }
    }
}
