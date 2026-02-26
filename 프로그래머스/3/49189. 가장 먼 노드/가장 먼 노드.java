/*
1번에서 출발해서 최장 거리 노드들 반환.
도착지 까지는 최단거리로 이동.

노드 개수 n : 2 <= n <= 2*10^4
간선 양방향 e : 1<= e <= 5*10^4

1번 출발 bfs 기록
O(e * log(v))
time ok

*/
import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    int[] dist;
    ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] edge) {
        // initialize
        dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) dist[i] = INF;
        
        adj = new ArrayList[n + 1];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int[] e : edge) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        int answer = 0;
        
        // run dijkstra
        bfs(1);
        
        // count far dist
        int maxDist = 0;
        for (int nodeDist : dist) {
            if (nodeDist == INF) continue;
            if (maxDist == nodeDist) {
                answer++;
            }
            else if (maxDist < nodeDist) {
                answer = 1;
                maxDist = nodeDist;
            }
        }
        
        return answer;
    }
    
    void bfs(int start) {
        dist[start] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : adj[curr]) {
                if (dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;
                    queue.add(next);
                }
            }
        }
        
        return;
    }
}