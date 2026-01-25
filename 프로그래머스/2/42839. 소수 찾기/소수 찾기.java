import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        recursive("", numbers);
        
        return set.size();
    }
    
    // 순열을 만들고 소수라면 set에 add 하는 재귀 함수
    public void recursive(String current, String numbers) {
        // 만든 순열이 소수라면 set 추가
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        // 순열 만들기
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
        
    }
    
    
    // 소수 체크 함수
    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}