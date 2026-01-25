import java.util.*;

class Solution {
    public static final int[][] PATTERNS = {{},
                                   {1, 2, 3, 4, 5},
                                   {2, 1, 2, 3, 2, 4, 2, 5},
                                   {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                                  };
    
    public int[] solution(int[] answers) {
        int[] scores = new int[4];
        
        int maxScore = 0;
        
        for (int i = 1; i <= 3; i++) {
            scores[i] = supo(i, answers);
            
            maxScore = Math.max(scores[i], maxScore);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= 3; i++) {
            if (maxScore == scores[i]) {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    // 수포자
    public int supo(int patternIndex, int[] answers) {
        int score = 0;
        int[] pattern = PATTERNS[patternIndex];
        
        for (int i = 0; i < answers.length; i++) {
            int index = i % pattern.length;
                
            if (answers[i] == pattern[index]) {
                score++;
            }
        }
        
        return score;
    }
}