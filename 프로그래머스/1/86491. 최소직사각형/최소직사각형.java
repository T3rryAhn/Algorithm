// 목표
// 모든 명함을 수납할 수 있는 가장 작은 지갑의 크기를 반환.

// 전략
// 1. 각각의 지갑의 가로, 세로를 크기 순으로 스왑
// 2. 전체 가로, 세로의 max 값을 구함
// 3. 면적을 리턴

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int[] s : sizes) {
            int tmp = s[0];
            
            if (s[0] < s[1]) {
                s[0] = s[1];
                s[1] = tmp;
            }
            
            maxW = Math.max(maxW, s[0]);
            maxH = Math.max(maxH, s[1]);
        }
        
        return maxW * maxH;
    }
}