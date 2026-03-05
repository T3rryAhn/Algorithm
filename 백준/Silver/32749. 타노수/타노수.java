import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        String x = br.readLine();

        int blockSize = 1 << (n - t);
        
        String maxVal = "";

        for (int i = 0; i < x.length(); i += blockSize) {
            String currentBlock = x.substring(i, i + blockSize);

            if (maxVal.equals("") || currentBlock.compareTo(maxVal) > 0) {
                maxVal = currentBlock;
            }
        }

        System.out.println(maxVal);
    }
}