import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static int[] alphaCounts = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        br.close();

        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            countAlpha(input.charAt(i));
        }

        int max = getMax(alphaCounts);
        int maxAlphaCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (max == alphaCounts[i]) {
                maxAlphaCount++;
                maxIndex = i;
            }
        }

        char result = 0;
        if (maxAlphaCount > 1) {
            result = '?';
        } else if (maxAlphaCount == 1) {
            result = alphabets[maxIndex];
        }
        System.out.println(result);
    }

    public static void countAlpha(char a) {
        for (int i = 0; i < 26; i++) {
            if (a == alphabets[i]) {
                alphaCounts[i]++;
            }
        }
    }

    public static int getMax(int[] a) {
        int tmp = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > tmp) {
                tmp = a[i];
            }
        }
        return tmp;
    }
}