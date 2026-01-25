// 전략
// array.sort() 사용 nlogn
// substring

// 슈도코드
/*
answer [commands.len]

for (i = 0; i < commands.len; i++) {
    command = commands[i]
    subarray = subarray(array, command[0] + 1, command[1] + 1)
    subarray.sort()
    
    answer[i] = subarray[command[2] + 1];
}
*/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            
            answer[i] = subArray[command[2] - 1];
        }
        
        return answer;
    }
}