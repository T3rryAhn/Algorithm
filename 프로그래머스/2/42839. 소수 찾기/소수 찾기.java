// 목표
// 만들수 있는 소수의 갯수 반환

// 조건
// 소수는 2이상, 1과 자신으로만 나누어지는 숫자.
// 숫자의 갯수는 1~ 7개
// 0 - 9 의 숫자
// 011 와 11 은 같은 숫자로 친다.

// 전략
// 2^7-1 의 가지수
// 자리수가 중요하니 문자로 조합후 숫자로 변환
// 0이 맨앞에 와서 생기는 중복 방지를 위해 set에 넣고 갯수를 센다.
// 우선 완전 탐색
// 재귀 vs 비트 -> 재귀

// 재귀함수
// numbers를 가지고 가능한 모든 숫자의 조합을 만들고 소수라면 소수를 set에 등록

// 종료 조건
// numbers의 길이만큼 숫자를 뽑았다면 종료

// 소수 체크
// 2 ~ 자기자신 - 1 숫자까지 반복문으로 나머지 0 있으면 소수가 아님

// 인자
// 현재 몇번째 재귀인지, 이전 재귀 뽑기 값, numbers
import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        recursive("", numbers);
        
        System.out.println(set);
        return set.size();
    }
    
    public void recursive(String current, String numbers) {
        // 종료
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num))
                set.add(num);
        }
        
        //순열 생성
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    // 소수 체크 함수
    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
}