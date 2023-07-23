import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String s = sc.next();
            sc.nextLine();

            //메서드실행
            String result = makeString(s, r);
            System.out.println(result);
        }

        sc.close();

    }

    public static String makeString(String s, int r) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        String[] letters = s.split("");

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < r; j++) {
                sb.append(letters[i]);
            }
        }
        result = sb.toString();
        return result;
    }
}
