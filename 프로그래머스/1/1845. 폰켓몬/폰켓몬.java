/* 목표 
 * 최대한 많은 종류의 포켓몬을 가져갈 수 있는 수 반환. MAX
 * 
 * 조건
 * - n / 2 만 가져갈수있음.
 * - 종류 중복 있음
 * 
 * 1 <= N <= 10^4. 항상 짝수
 * 1 <= nums <= 2 * 10^5
*/

// 전략
// hashmap에 넣고, len을 세면 그것이 종류의 갯수
// min(종류의 갯수, N/2)

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, 0);
        }
        
        return Math.min(map.size(), nums.length / 2);
    }
}