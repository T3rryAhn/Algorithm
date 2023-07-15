import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.charAt(i) - 48;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        System.out.println(sum);
    }
}
