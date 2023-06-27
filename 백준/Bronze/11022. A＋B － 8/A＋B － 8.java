import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= caseCount; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bw.write("Case #" + i + ": ");
            bw.write(a + " + " + b + " = ");
            bw.write(String.valueOf(a + b));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
