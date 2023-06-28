import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b;
        String input = "";
      
        while ((input = br.readLine()) != null) {
            String[] numbers = input.split(" ");
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);

            bw.write(String.valueOf(a + b));
            bw.flush();
            bw.newLine();
        }
        bw.close();
    }
}
