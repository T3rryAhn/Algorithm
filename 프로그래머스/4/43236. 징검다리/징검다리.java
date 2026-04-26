/*
바위 위치를 오름차순 정렬
사이 간격 배열 생성
제일 작은거 제거하면서 뒤 원소에 합치기 (리스트)
검사
*/
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int removeRocks = 0;
            
            int prePos = 0;
            for (int rock : rocks) {
                if (rock - prePos < mid) {
                    removeRocks++;
                }
                else {
                    prePos = rock;
                }
            }
            
            // dist between last rock and goal
            if (distance - prePos < mid) {
                removeRocks++;
            }
            
            if (removeRocks <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        
        
        return answer;
    }
}