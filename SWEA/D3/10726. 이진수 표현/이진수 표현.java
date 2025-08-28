import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            boolean isOn = false;

            int a = (1 << N) - 1;

            isOn = (a & M) == a;

            System.out.printf("#%d %s%n", tc, isOn ? "ON" : "OFF");
        }
    } 
}
