import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            bw.append(repeater(" ", input - 1 - i))
                    .append(repeater("*", i * 2 + 1)).append("\n");
        }
        for (int i = 0; i < input - 1; i++) {
            bw.append(repeater(" ", i + 1))
                    .append(repeater("*", (input - 1 - i) * 2 - 1));
            if (i != input - 1) {
                bw.append("\n");
            }
        }

        bw.close();

    }

    static String repeater(String s, int a) {
        String result = "";
        for (int i = 0; i < a; i++) {
            result += s;
        }
        return result;
    }
}
