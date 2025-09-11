

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] graph;
	static int[][] dist;
	static int N;
	
	static final int INF = Integer.MAX_VALUE;

	// direction. up, down, left, right
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
//		File file = new File("./src/swea/_1249_보급로/input (4).txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// case start
			N = sc.nextInt();
			
			// init
			graph = new int[N][N];
			dist = new int[N][N];
			for(int[] row : dist) Arrays.fill(row, INF);
			
			for(int r = 0; r < N; r++) {
				String row = sc.next();
				for(int c = 0; c < N; c++) {
					graph[r][c] = Character.digit(row.charAt(c), 10);
				}
			}
			
			
			dijkstra(0, 0);
			
			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
			
			
			// case end
		}

	}
	
	static boolean isInBound(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void dijkstra(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		dist[r][c] = 0;
		int cr = r, cc = c;
		
		q.add(new int[] {cr, cc} );
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cr = cur[0];
			cc = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(isInBound(nr, nc) && dist[nr][nc] > dist[cr][cc] + graph[nr][nc]) {
					dist[nr][nc] = dist[cr][cc] + graph[nr][nc];
					q.add(new int[] {nr, nc});
				}
			}
		}
		
	}
}
