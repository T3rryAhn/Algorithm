import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] alphabetUsedCheck = new int[26];

        for (int i = 0; i < 26; i++) {
            alphabetUsedCheck[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (alphabetUsedCheck[j] != -1) {
                    continue;
                }
                if (s.charAt(i) == alphabets[j]) {
                    alphabetUsedCheck[j] = i;
                }
            }
        }

        for (int i : alphabetUsedCheck) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
