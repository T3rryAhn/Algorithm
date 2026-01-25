// hashmap
// 참가자 명단을 hashmap에 등록 (참가자이름 : 인원)
// 완주자 명단을 보며 장부에서 숫자 빼기
// 최종 확인시 숫자가 남은 이름이 미완주자

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}