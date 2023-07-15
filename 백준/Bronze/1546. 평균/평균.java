import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        double result = fixScore(maxScore(scores), avg(scores));
        System.out.println(result);
    }

    public static int maxScore(int[] arrays) {
        int tmp = arrays[0];
        for (int i : arrays) {
            if (i > tmp) {
                tmp = i;
            }
        }
        return tmp;
    }

    public static double fixScore(int maxScore, double score) {
        return score / maxScore * 100;
    }

    public static double avg(int[] arrays) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i];
        }
        return (double) sum / arrays.length;
    }
}