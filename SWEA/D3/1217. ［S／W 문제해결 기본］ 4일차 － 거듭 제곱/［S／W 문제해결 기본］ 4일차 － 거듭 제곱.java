import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int caseNum = sc.nextInt();

            System.out.printf("#%d %d%n", caseNum, pow(sc.nextInt(), sc.nextInt()));
        }
    }

    static int pow(int c, int n) {
        if (n == 0)
            return 1;

        if (n % 2 == 1) {
            int tmp = pow(c, (n - 1)/2);
            return tmp * tmp * c;
        }
        else {
            int tmp = pow(c, n / 2);
            return tmp * tmp;
        }
    }
}
