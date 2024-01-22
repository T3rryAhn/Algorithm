import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowInput = new int[9];
        Info maxNumberInfo = new Info(-1, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowInput[j] = sc.nextInt();
            }
//            System.out.println(Arrays.toString(rowInput));
            maxNumberInfo = checkRow(rowInput, maxNumberInfo, i);
        }
        sc.close();
        printResult(maxNumberInfo);
    }

    static Info checkRow(int[] rowInput, Info maxNumberInfo, int row) {
        int column = 0;

        int temp;
        for (int i = 0; i < rowInput.length; i++) {
            temp = rowInput[i];
            if (temp > maxNumberInfo.number) {
                int max = temp;
                column = i + 1;
                maxNumberInfo = new Info(max, row + 1, column);
            }
        }

        return maxNumberInfo;
    }

    static void printResult(Info number) {
        System.out.println(number.number);
        System.out.println(number.row + " " + number.column);
    }
}

class Info {
    int number;
    int row;
    int column;

    public Info(int number, int row, int column) {
        this.number = number;
        this.row = row;
        this.column = column;
    }
}


