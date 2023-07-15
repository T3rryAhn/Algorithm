import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);
            System.out.println("" + firstChar + lastChar);
        }
    }
}
