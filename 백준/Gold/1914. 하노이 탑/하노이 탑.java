import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.close();
        
        BigInteger count = BigInteger.ONE.shiftLeft(K).subtract(BigInteger.ONE);
        System.out.println(count);
        if (K <= 20) {
            hanoi(K, 1, 2, 3);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }


    }

    public static void hanoi(int n, int from, int tmp, int to) {
        if (n == 0)
            return;
        
        hanoi(n - 1, from, to, tmp);
        String str = from + " " + to + "\n";
        sb.append(str);
        hanoi(n - 1, tmp, from, to);
    }
}
