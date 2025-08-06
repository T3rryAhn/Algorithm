import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String str = sc.nextLine();
            boolean isPalin = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    isPalin = false;
                    System.out.printf("#%d %d%n", caseNum, 0);
                    break;
                }
            }
            if (isPalin) {
                System.out.printf("#%d %d%n", caseNum, 1);
            }
        }

    }

}
