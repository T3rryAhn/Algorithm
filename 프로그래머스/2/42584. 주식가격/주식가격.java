// 목표
// 주식 가격이 떨어지지 않은 기간 초 반환

// 분석
// 초 <= 10^4
// price <= 10^5
// 각 원소에 대해 탐색을 해봐야함.
// 해당 원소로 부터 인덱스가 증가하는데, 원소보다 작은 원소값을 만나거나 배열의 끝을 만나면
// 만난 원소의 갯수가 초임.

// 완전탐색
// for문 모든 원소 반복 {for 뒷 부분 원소 탐색하면서 기록}
//


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int curr = prices[i];
            int sec = 0;
            
            for (int j = i + 1; j < prices.length; j++) {
                sec++;
                
                if (prices[j] < curr) {
                    break;
                }
            }
            answer[i] = sec;
        }
        
        return answer;
    }
}