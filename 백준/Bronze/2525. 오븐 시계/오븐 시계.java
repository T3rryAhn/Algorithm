import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int cookTime = sc.nextInt();
        sc.close();

        int alarm = h * 60 + m + cookTime;
        int alarmHour = alarm / 60 % 24;
        int alarmMin = alarm % 60;

        System.out.println(alarmHour + " " + alarmMin);
    }
}