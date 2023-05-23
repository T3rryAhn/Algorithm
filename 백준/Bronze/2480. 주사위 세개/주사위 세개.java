import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        int count = 0;
        int resultNum = 0;
        int result = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.close();

        int numbers[] = {a, b, c};

        for (int i = 0; i < 3; i++) {
            count = 0;
            if (numbers[i] == a ) {
                count++;
            }
            if (numbers[i] == b) {
                count++;
            }
            if (numbers[i] == c) {
                count++;
            }
            if (count > 1) {
                resultNum = numbers[i];
                break;
            }
        }

        //중복 숫자 없다면 최댓값 구하기
        if (count == 1) {
            for (int i = 0; i < 3; i++) {
                if (resultNum < numbers[i]) {
                    resultNum = numbers[i];
                }
            }
            result = resultNum * 100;
        } else if (count == 2) {
            result = 1000 + resultNum * 100;
        } else if (count == 3) {
            result = 10000 + resultNum * 1000;
        }

        System.out.println(result);
    }
}