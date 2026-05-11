import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] operations) {
		int[] answer = {0, 0};
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		for (String o : operations) {
			String[] parts = o.split(" ");
			Integer num = Integer.parseInt(parts[1]);
			Entry<Integer, Integer> entry = null;
			
			if (parts[0].equals("I")) {
				tm.put(num, tm.getOrDefault(num, 0) + 1);
			}
			else {
				if (num == 1) {
					entry = tm.lastEntry();
				}
				else {
					entry = tm.firstEntry();
				}
				
				if (entry == null) continue;
				
				if (entry.getValue() > 1) {
					tm.replace(num, entry.getValue() - 1);
				}
				else {
					tm.remove(entry.getKey());
				}
				entry = null;
			}
		}
		
		answer[0] = tm.lastEntry() != null ? tm.lastKey() : 0;
		answer[1] = tm.firstEntry() != null ? tm.firstKey() : 0;
		
		return answer;
    }
}