import java.io.*;

public class Main {
    private static final int maxDate = 641;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int quotient = n / 3;
        int remainder = n % 3;
        int min;

        if (remainder == 0) {
            min = quotient;
        } else {
            min = quotient + 1;
        }

        for (int i = 0; i < quotient; i++) {
            int a = i * 3;
            String tempStr = "" + number.charAt(a) + number.charAt(a + 1) + number.charAt(a + 2);
            int tempInt = Integer.parseInt(tempStr);

            if(number.charAt(a) == '0') {
                min++;
                break;
            }

            if(tempInt > maxDate) {
                min++;
                break;
            }
        }
        if(remainder == 2) {
            if(number.charAt(number.length() - 2) == '0') {
                min++;
            }
        }
        System.out.println(min);

    }
}