import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        br.readLine();
        String [] numbers = br.readLine().split(" ");
        String v = br.readLine();

        for (String i : numbers) {
            if (v.equals(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}

