// 목표
// 

// 전략
// set 사용
// 

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        boolean result = true;
        
        for (String p : phone_book) {
            set.add(p);
        }
        
        for (String s : set) {
            for (int i = 1; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return result;
    }
}