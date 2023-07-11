import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean[] homeWorkCheck = new boolean[30];
        for(int i = 0; i < 28; i++){
            int studentNum = Integer.parseInt(sc.nextLine()) - 1;
            homeWorkCheck[studentNum] = true;
        }

        for(int i = 0; i < homeWorkCheck.length; i++) {
            if (!homeWorkCheck[i]) {
                System.out.println(i + 1);
            }
        }
    }
}