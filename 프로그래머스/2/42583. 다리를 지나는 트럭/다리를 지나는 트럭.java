/*
    # 문제 분석
        - bridege_length 가 트럭 댓수 제한
        - 다리는 weight `이하` 까지 ok
    # 조건
        int
        
    # 전략
        - 큐
        - 큐 == 다리. 큐 사이즈를 다리 길이 만큼만듬
        - 빈칸은 `0` 을 삽입
        - 변수에 현재 다리에 올라간 트럭 무게 저장
        - 매초 마다 반복
        - 무게 비교 후 큐 삽입
        
        
*/
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new ArrayDeque<>(bridge_length);
        
        // bridge initializie. fill with zero. zero means empty place.
        for (int i = 0; i < bridge_length; i++) bridge.offer(0);
        
        int time = 0;
        int idx = 0;    // truck index.
        int totalWeight = 0;
            
        while(idx < truck_weights.length || totalWeight > 0) {
            time++;
            
            // after 1sec. first cell out.
            totalWeight -= bridge.poll();
            
            // raise the next truck if you can.
            if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight) {
                int in_weight = truck_weights[idx];
                bridge.offer(in_weight);
                totalWeight += in_weight;
                idx++;
            }
            else {
                bridge.offer(0);
            }
        }
        
        
        return time;
    }
}