import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*
 * 암호문 문텅이들이 뭉텅이채로 추가, 삭제, 맨뒤추가가 자주 일어날꺼고 뭉탱이채로임.
 * 이거 완전 LinkedList 아님???
 * 암호문 LinkedList로 저장해서 메서드 쓰면 뚝딱가능해보임
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_1230_암호문\\input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            // each case start
            List<Integer> passwords = new LinkedList<>();

            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                passwords.add(sc.nextInt());
            }
            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int x, y;
                String command = sc.next();
                
                switch (command) {
                    case "I":
                        x = sc.nextInt();
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            // 앞에서부터 x번째 암호문 바로 다음에 !! 주의 "번째"
                            passwords.add(x++, sc.nextInt());
                        }
                        break;

                    case "D":
                        x = sc.nextInt();
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            // 앞에서부터 x번째 암호문 바로 다음부터
                            passwords.remove(x);
                        }
                        break;

                    case "A":
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            passwords.add(sc.nextInt());
                        }
                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + caseNum + " ");
            for (int j = 0; j < 10; j++) {
                sb.append(passwords.remove(0) + " ");
            }
            System.out.println(sb);

            // each case end
        }
    }
}
