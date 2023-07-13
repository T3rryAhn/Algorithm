import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int[] uniqueNumbers = new int[10];
        int uniqueNumCount = 0;

        for (int i = 0; i < 10; i++) {
            uniqueNumbers[i] = -1;
        }
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt() % 42;
        }

        for (int i : numbers) {
            boolean duplicateCheck = false;
            for (int j : uniqueNumbers) {
                if (i == j) {
                    duplicateCheck = true;
                    break;
                }
            }
            if (!duplicateCheck) {
                uniqueNumCount++;
                uniqueNumbers[uniqueNumCount - 1] = i;
            }
        }

        System.out.println(uniqueNumCount);
    }
}