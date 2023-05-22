import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        if (h == 0 && m < 45) {
            h = 24;
        }

        int alarm = h * 60 + m - 45;
        int alarmHour = alarm / 60;
        int alarmMin = alarm % 60;

        System.out.println(alarmHour + " " + alarmMin);
    }
}