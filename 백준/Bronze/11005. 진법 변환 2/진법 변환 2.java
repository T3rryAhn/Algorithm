import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        List<Integer> result = new ArrayList<>();

        while (n > 0) {
            int q = n / b;
            int r = n % b;

            result.add(r);
            n = q;
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) > 9) {
                char ch = (char) (result.get(i) - 10 + 'A');
                System.out.print(ch);
            } else {
                System.out.print(result.get(i));
            }
        }
    }
}
