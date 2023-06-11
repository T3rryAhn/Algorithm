import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseValue = sc.nextInt();
        int[] results = new int[caseValue];
        for (int i = 0; i < caseValue; i++) {
            results[i] = sc.nextInt() + sc.nextInt();
        }

        for (int i : results) {
            System.out.println(i);
        }
    }
}