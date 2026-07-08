/*
0) line 안에서 line 2개 선정 완탐으로 가는데 n, n-1, n-2... 반복
1) 평행한지 체크 if
2) false 라면, 교점 연산
    2-0) 교점이 정수인지 체크
    2-1) 저장시 max, min (x, y) 갱신
    2-2) set 에 저장
3) min, max 기반 출력용 배열 생성 기본 '.' 으로 초기화
4) 출력용 배열에서 set 좌표 마다 '*'로 변경
5) 출력

*/
import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        
        long maxX, minX, maxY, minY;
        maxX = Integer.MIN_VALUE; maxY = Long.MIN_VALUE;
        minX = Integer.MAX_VALUE; minY = Long.MAX_VALUE;
        
        Set<List<Long>> coordinate = new HashSet<>();
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];
                
                long denominator = a*d - b*c;
                if (denominator == 0) continue;
                
                long numerator1 = b*f - e*d, numerator2 = e*c - a*f;
                if (numerator1 % denominator != 0 || numerator2 % denominator !=0 ) continue;
                
                long x = numerator1 / denominator;
                long y = numerator2 / denominator;
                
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
                
                coordinate.add(Arrays.asList(x, y));
            }
        }
        
        int rowSize = (int)(maxY - minY + 1);
        int colSize = (int)(maxX - minX + 1);
        
        StringBuilder[] sbAnswer = new StringBuilder[rowSize];
        
        for (int i = 0; i < rowSize; i++) {
            sbAnswer[i] = new StringBuilder(".".repeat(colSize));
        }
        
        for (List<Long> c : coordinate) {
            int row = (int)(maxY - c.get(1));
            int col = (int)(c.get(0) - minX);
            
            sbAnswer[row].setCharAt(col, '*');
        }
        
        answer = new String[rowSize];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sbAnswer[i].toString();
        }
        
        return answer;
    }
    
    static class Point {
        long x;
        long y;
    }
}