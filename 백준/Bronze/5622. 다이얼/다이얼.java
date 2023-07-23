import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        sc.close();

        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            sum += charToSec(input.charAt(i));
        }
        System.out.println(sum);

    }

    static int charToSec(char a){

        int sec = 0;
        switch (a) {
            case 'A': case 'B': case 'C':
                sec = 3;
                break;
            case 'D': case 'E': case 'F':
                sec = 4;
                break;
            case 'G': case 'H': case 'I':
                sec = 5;
                break;
            case 'J': case 'K': case 'L':
                sec = 6;
                break;
            case 'M': case 'N': case 'O':
                sec = 7;
                break;
            case 'P': case 'Q': case 'R': case 'S':
                sec = 8;
                break;
            case 'T': case 'U': case 'V':
                sec = 9;
                break;
            case 'W': case 'X': case 'Y': case 'Z':
                sec = 10;
                break;
        }
        return sec;
    }
}