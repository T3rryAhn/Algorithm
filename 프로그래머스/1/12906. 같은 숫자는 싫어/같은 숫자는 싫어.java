import java.util.*;

public class Solution {
    Stack<Integer> stack;
    List<Integer> list = new LinkedList<>();
    
    public int[] solution(int []arr) {
        stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        
        int current = -1;
        while(!stack.isEmpty()) {
            int num = stack.pop();
            
            if (current == num) {
                continue;
            }
            
            list.add(num);
            current = num;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.remove(list.size() - 1);
        }
        
        return answer;
        
    }
}