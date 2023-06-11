import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int count = n / 4;
        String result = "";

        for (int i = 0; i < count; i++) {
            result += "long ";
        }
        result += "int";

        System.out.println(result);
    }
}