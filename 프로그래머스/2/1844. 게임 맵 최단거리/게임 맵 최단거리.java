import java.util.*;

class Solution {
    int n;  // rows
    int m;  // cols
    int[][] mapsG;
    int[][] dist;
    int INF = Integer.MAX_VALUE;
    
    // moves. right, down, left, up
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        mapsG = maps;
        dist = new int[n][m];
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dist[r][c] = INF;
            }
        }
        
        findPath(0, 0);
        
        return dist[n - 1][m - 1] == INF ? -1 : dist[n - 1][m - 1];
    }
    
    // Djsktra
    public void findPath(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        dist[startR][startC] = 1;
        
        queue.offer(new int[] {startR, startC});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int d = 0; d < dr.length; d++) {
                int currR = curr[0];
                int currC = curr[1];
                
                int nextR = currR + dr[d];
                int nextC = currC + dc[d];
                
                // 범위를 벗어나거나 길이 아니라면 킵
                if (!isInBound(nextR, nextC) || mapsG[nextR][nextC] != 1)
                    continue;
                
                // 이번에 이동한 거리가 기존 기록보다 짧다면 큐에 넣는다.
                if (dist[nextR][nextC] > dist[currR][currC] + 1) {
                    queue.offer(new int[] {nextR, nextC});
                    dist[nextR][nextC] = dist[currR][currC] + 1;
                } 
            }
        }
    }
    
    
    // bound checker
    public boolean isInBound(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}