import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] baskets = new int[n];
        int i, j;

        for (int a = 0; a < n; a++) {
            baskets[a] = a + 1;
        }

        for (int a = 0; a < m; a++) {
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;

            exchanger(baskets, i, j);
        }

        for (int a = 0; a < baskets.length; a++) {
            System.out.print(baskets[a]);
            if (a == baskets.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }

    public static void exchanger(int[] arrays, int i, int j) {
        /*for (int a = 0; a < j - i; a++) {
            int tmp;
            tmp = arrays[a + i];
            arrays[a + i] = arrays[j - a];
            arrays[j - a] = tmp;
        }
       */
        while (i < j) {
            int tmp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = tmp;
            i++;
            j--;
        }
    }
}