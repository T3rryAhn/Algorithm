/*
    문제 분석
    
    scoville.len : 2 ~ 10^6
    K : 0 ~ 10^9
    scoville : 0 ~ 10^6
    
    최솟값과 그 다음 최솟값을 항상 반복해서 꺼내야한다.
    그리고 다시 새로운 값을 넣고 다시 최솟값을 꺼내야한다.
    
    전략
    정렬? 
    
    시간 복잡도
    
    10^6 * 3 * log(10^6)
             
*/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int s : scoville) minHeap.add(s);
        
        
        int count = 0;

        while(minHeap.size() >= 2 && minHeap.peek() < K) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            minHeap.add(a + 2 * b);
            count++;
        }
        
        return !minHeap.isEmpty() && minHeap.peek() >= K ? count : -1;
    }
}