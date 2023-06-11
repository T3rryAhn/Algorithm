import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String payCheck = "No";
        int x;
        int n;
        int a, b;
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sum += a * b;
        }

        if (x == sum) {
            payCheck = "Yes";
        }

        System.out.println(payCheck);
    }
}