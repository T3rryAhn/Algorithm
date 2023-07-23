import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        a = reverseInt(a);
        b = reverseInt(b);

        System.out.println(Integer.max(a, b));
    }

    public static  int reverseInt(int x) {
        String num = Integer.toString(x);
        String result = "";
        for (int i = 0; i < num.length(); i++) {
           result += num.charAt(num.length() - 1 - i);
        }
        int resultToInt = Integer.parseInt(result);

        return resultToInt;
    }
}