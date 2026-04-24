/*
카운팅 정렬

n으로 돌면서 최댓값 확인
배열생성
카운팅 시작
누적합 덮어쓰기

*/
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int maxNum = 0;
        for (int c : citations) maxNum = Math.max(maxNum, c);
        
        int[] countArr = new int[maxNum + 1];
        
        for (int c : citations) countArr[c]++;

        for (int i = countArr.length - 2; i >= 0; i-- ) {
            countArr[i] += countArr[i + 1];
        }
        
        for (int h = countArr.length - 1; h >= 0; h-- ) {
            if (h <= countArr[h] && countArr[0] <= 2 * countArr[h]) {
                answer = h;
                break;
            }
        }
        // System.out.println(Arrays.toString(countArr));
        
        return answer;
    }
}