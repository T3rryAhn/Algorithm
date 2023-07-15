import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int index = sc.nextInt() - 1;
        sc.close();

        System.out.println(s.charAt(index));
    }
}