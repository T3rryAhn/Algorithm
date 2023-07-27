import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        sc.close();

        PalindromeChecker palinCheck = new PalindromeChecker(input);
        System.out.println(palinCheck.isPalindrome());
    }
}

class PalindromeChecker {
    String word;
    char[] letters;
    int palindromeCheck = 0; // true = 1, false = 0

    PalindromeChecker(String input) {
        this.word = input;
        this.letters = input.toCharArray();
    }

    int isPalindrome() {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != letters[letters.length - 1 - i]) {
                palindromeCheck = 0;
                break;
            }
            palindromeCheck = 1;
        }
        return palindromeCheck;
    }

}