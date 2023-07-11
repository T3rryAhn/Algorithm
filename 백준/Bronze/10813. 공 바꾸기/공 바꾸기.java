import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        //바구니 생성
        int[] baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }

        //입력 받고 수행
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();

            basketChanger(baskets, a, b);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(baskets[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

    }

    public static void basketChanger(int[] baskets, int a, int b) {
        a -= 1;
        b -= 1;
        int tmp = baskets[a];
        baskets[a] = baskets[b];
        baskets[b] = tmp;
    }
}