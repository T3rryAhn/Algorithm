import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int line = sc.nextInt();
        sc.nextLine();
        String[] words = new String[line];
        for (int i = 0; i < line; i++) {
            words[i] = sc.nextLine();
        }
        sc.close();

        int count = 0;

        for (String word : words) {
            int pointerS = 0;
            int pointerE = 0;
            int tmp = 0;
            boolean check = true;
            while (pointerS < word.length()) {
                if (word.charAt(pointerS) == word.charAt(pointerE)) {
                    if (pointerE - tmp > 1) {
                        check = false;
                    }
                    tmp = pointerE;
                    pointerE++;
                } else {
                    pointerE++;
                }
                if (pointerE > word.length() - 1) {
                    pointerS++;
                    pointerE = pointerS;
                    tmp = pointerS;
                }
            }
            if (check) {
                count++;
            }
        }

        System.out.println(count);
    }
}
