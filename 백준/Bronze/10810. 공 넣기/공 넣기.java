import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] baskets = new int[n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();

            basketPutter(baskets, a, b, c);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(baskets[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

    }

    public static void basketPutter(int baskets[], int a, int b, int c) {
        for (int i = 0; i < b - a + 1; i++) {
            baskets[a + i - 1] = c;
        }
    }
}