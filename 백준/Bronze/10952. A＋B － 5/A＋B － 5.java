import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b;

        do {
            String [] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);

            if (!(a + b == 0)) {
                bw.write(String.valueOf(a + b));
                bw.newLine();
            }
        } while (a != 0 || b != 0);

        br.close();
        bw.close();
    }
}
