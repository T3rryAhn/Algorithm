import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = br.readLine()) != null) {
            if (input.equals("")) {
                break;
            }
            bw.write(input);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}