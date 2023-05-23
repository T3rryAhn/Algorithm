import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();
        String result;

        result = str.replace("XXXX", "AAAA");
        result = result.replace("XX", "BB");

        if (result.contains("X")) {
            result = "-1";
        }
        System.out.println(result);
    }
}