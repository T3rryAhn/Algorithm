import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();
        sc.close();

        int[] nToInt = new int[n.length()];

        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                nToInt[i] = num;
            } else {
                int num = ch - 'A' + 10;
                nToInt[i] = num;
            }
        }

        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            result += nToInt[i] * power(b, n.length() - 1 - i);
        }
        System.out.println(result);
    }

    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
