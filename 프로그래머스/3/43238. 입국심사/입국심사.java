/*
    # 문제 분석
        사람 n : 1 ~ 10^9
        심사시간 times[i] : 1 ~ 10^9
        심사관 수 m : 1 ~ 10^5

        여러 심사관이 병렬로 심사를 진행한다.
        어떤 시간 T가 주어졌을 때,
        각 심사관은 T / times[i] 명을 처리할 수 있다.

        전체 처리 가능 인원:
            sum(T / times[i])

        이 값은 T가 증가할수록 절대 감소하지 않는다.

        목표:
            sum(T / times[i]) >= n 을 만족하는
            최소 시간 T를 구한다.

        리턴값은 최대 10^18 이므로 long 사용.


    # 전략 (이분 탐색)

        1. 탐색 범위 설정
            low = 0
            high = max(times) * n

        2. mid 시간에 대해 처리 가능 인원 계산
            processed = Σ(mid / times[i])

        3. 만약 processed >= n 이면
               -> 해당 시간은 가능
               -> 답 후보로 저장
               -> 더 작은 시간 탐색 (high = mid)
           아니면
               -> 시간이 부족
               -> 더 큰 시간 탐색 (low = mid + 1)

        4. 탐색 종료 후 최소 가능 시간 반환


    # 시간 복잡도

        한 번의 처리량 계산: O(m)
        이분 탐색 횟수: O(log(max(times) * n)) ≈ 최대 60회

        전체 시간 복잡도:
            O(m log(max시간))

        최대:
            10^5 * 60 ≈ 6,000,000

        메모리 복잡도:
            O(1)
*/


import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0, right = 0;
        long maxValue = 0;
        for (long t : times) maxValue = Math.max(maxValue, t);
        right = maxValue * n;
        
        while (left < right) {
            long mid = left + (right - left) / 2;

            long processed = 0;
            for (long t : times) processed += mid / t;
            
            if (processed >= n) {
                answer = mid;
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}