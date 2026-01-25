// 목표
// 카펫의 가로, 세로 크기 를 배열로 반환

// 조건
// 8 <= brown <= 5*10^3
// 1 <= yellow <= 2 * 10^6
// 가로 >= 세로

// 전략
// 노랑의 {약수1, 약수2}
// 가로, 세로 = 약수1 + 2, 약수2 + 2
// 약수1 + 약수 2 + 2 = 갈색 / 2
//
// 반복문으로 노랑의 약수 1 부터 자기자신까지 (실제로는 제곱근 올림 까지 진행될것임)
// 브라운 갯수와 일치하면 반환 후 종료


// 슈도 코드

/* 
for (i = 1; i <= yellow; i++) {
    약수1, 약수2
    if (약수1 + 약수 2 + 2 = 갈색 / 2)
        return 약수1 + 2, 약수2 + 2;
}
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int w = 0, h = 0;
        
        for (int i = 1; i <= yellow; i++) {
            w = i;
            
            if (yellow % w != 0)
                continue;
            
            h = yellow / w;
            
            if (w + h + 2 == brown / 2) {
                // swap
                int tmp = w;
                if (w < h) {
                    w = h;
                    h = tmp;
                }
                
                answer = new int[] {w + 2, h + 2};
                break;
            }
        }
        
        return answer;
    }
}