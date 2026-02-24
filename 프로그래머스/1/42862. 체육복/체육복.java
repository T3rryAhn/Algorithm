/*
    # 문제 분석
    
    - 앞뒤 인덱스만 체육복 빌려주기 가능
    - 최대한 많은 인원이 체육복 가지도록
    
    도난 인원 수 : n (1 ~ n)
    전체 학생 수 : t (2 ~ 30) 
    여벌 체육복 가져온 학생 수 : s (1 ~ n) 중복 x
    
    - 여벌 체육복을 가져온 학생이 도난 당하면 빌려주기 x 본인이 입음.
    - 여벌 체육복은 한벌 가져오는 것
    
    # 전략
    
    1. 한번 순회하면서 우선 자기 자신 입기
    2. lost 0번 부터 순회
    3. 앞에서 요청
    4. 앞도 없다면 뒤에서 요청
    
    # 복잡도

*/
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Arrays.sort(lost);
        
        boolean[] hasMore = new boolean[n + 1];
        for (int index : reserve) {
            hasMore[index] = true;
        } 
        
        // 자기거 먼저 입기
        for (int i = 0; i < lost.length; i++) {
            int index = lost[i];
            
            if (hasMore[index]) {
                hasMore[index] = false;
                lost[i] = -1;
            }
        }
        
        for (int index : lost) {
            if (index == -1) continue;
            
            if (index > 0 && hasMore[index - 1]) {
                hasMore[index - 1] = false;
                continue;
            }
            else if (index < n && hasMore[index + 1]) {
                hasMore[index + 1] = false;
                continue;
            }
            answer--;
        }
        return answer;
    }
}