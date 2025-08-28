import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc = 1; tc <= T; tc++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            boolean isOn = true;
            for(int i = 0; i < N; i++) {
                 
                isOn = (M & (1 << i)) != 0;
                if(!isOn)  break; 
            }
 
            if(isOn)
                System.out.println("#" + tc + " " + "ON");
            else
                System.out.println("#" + tc + " " + "OFF");
        }
    }
}