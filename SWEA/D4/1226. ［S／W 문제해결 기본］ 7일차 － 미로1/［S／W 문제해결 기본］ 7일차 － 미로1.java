

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int N = 16;
	static boolean[][] visited;
	static int[] start;
	static int[] end;
	
	// 오 아 왼 위
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("./src/swea/_1226_미로1/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			// case start
			int caseNum = sc.nextInt();

			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				String row = sc.next();
				for (int c = 0; c < N; c++) {
					char tmp = row.charAt(c);

					switch (tmp) {
					case '1':
						visited[r][c] = true;
						break;
					case '2':
						start = new int[] { r, c };
						break;
					case '3':
						end = new int[] { r, c };
						break;
					}
				}
			}
			
			
			System.out.printf("#%d %d%n", caseNum, bfs());

			// case end
		}
	}// main

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();

		q.add(start);
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int d = 0; d < 4; d++ ) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(isInBound(nr, nc) && !visited[nr][nc]) {
					if(nr == end[0] && nc == end[1]) return 1;
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}

		return 0;
	}
	
	static boolean isInBound(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
