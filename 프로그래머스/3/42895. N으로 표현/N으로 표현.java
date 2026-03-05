/*
    dp[n] = 사칙연산(dp[n - 1], dp[1]) + 사칙연산(dp[n - 2], dp[2]) + ... + 사칙연산(dp[1], dp[ n - 1])
*/

import java.util.*;

class Solution {
    Set<Integer>[] memo = new Set[9];
    {
        for (int i = 0; i < memo.length; i++) memo[i] = new HashSet<>();
    }    
    
    
    public int solution(int N, int number) {
        int answer = -1;
        
        memo[1].add(N);
        
        for (int i = 2; i < memo.length; i++) {
            // 숫자N으로 만드는 수 추가
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp = tmp * 10 + N;
            }
            memo[i].add(tmp);
            
            // 사칙연산 추가
            for (int j = 1; j < i; j++) {
                for (int m1 : memo[j]) {
                    for (int m2 : memo[i - j]) {
                        memo[i].add(m1 + m2);
                        if (m1 > m2) {
                            memo[i].add(m1 - m2);
                        }
                        memo[i].add(m1 * m2);
                        if (m2 != 0) {
                            memo[i].add(m1 / m2);
                        }
                    }
                }
            }
        }
        
        for (int i = 1; i < memo.length; i++) {
            if (memo[i].contains(number)) {
                answer = i;
                break;
            }
        }
        // System.out.println(Arrays.toString(memo));
        
        return answer;
    }
}