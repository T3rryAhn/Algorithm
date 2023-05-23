import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        String[] result = str.split(" ");

        if (result.length == 0 ) {
            System.out.println("0");
        } else if (result[0].equals("")) {
            System.out.println(result.length - 1);
        } else {
            System.out.println(result.length);
        }
    }
}