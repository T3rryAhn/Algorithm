import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (x > Integer.parseInt(nums[i])) {
                System.out.print(nums[i] + " ");
            }
        }

    }
}

