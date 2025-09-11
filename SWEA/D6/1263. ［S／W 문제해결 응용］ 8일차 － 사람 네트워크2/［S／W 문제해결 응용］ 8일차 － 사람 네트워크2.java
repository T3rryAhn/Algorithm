

import java.io.*;
import java.util.*;


public class Solution {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
//		File file = new File("./src/swea/_1263_사람네트워크2/input (3).txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++ ) {
			// case start
			int N = sc.nextInt();
			
			int[][] dist = new int[N][N];
			for(int[] row : dist) Arrays.fill(row, INF);
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int tmp = sc.nextInt();
					if(r == c)
						dist[r][c] = 0;
					else if(tmp == 1)
						dist[r][c] = 1;
				}
			}
			
			
			for(int k = 0; k < N; k++) {
				for(int from = 0; from < N; from++) {
					if(dist[from][k] == INF) continue;
					for(int to = 0; to < N; to++) {
						if(dist[k][to] == INF) continue;
						if(dist[from][to] > dist[from][k] + dist[k][to] ) {
							dist[from][to] = dist[from][k] + dist[k][to];
						}
					}
				}
			}
			
			int cc = INF;
			for(int[] row : dist) {
				int sum = 0;
				for(int n : row) sum += n;
				cc = Math.min(cc, sum);
			}
			
			System.out.printf("#%d %d%n", tc, cc);
			// case end
		}
		
	}

}
