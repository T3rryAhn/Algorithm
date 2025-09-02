

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[][] graph;
	static boolean[][] visited;
	static int N;
	static int X;

	static int[] dr = { 0, 0, -1, 1 }; // 왼, 오, 위, 아래
	static int[] dc = { -1, 1, 0, 0 };
	static int count;

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src\\algo1\\sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// case start
			N = sc.nextInt();
			X = sc.nextInt();

			count = 0;
			graph = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}

			// 가로 검사
			for (int r = 0; r < N; r++) {
				boolean isOK = true;
				int pre = graph[r][0];

				for (int c = 0; c < N; c++) {
					
					if (!isOK)
						break;

					int diff = graph[r][c] - pre;
					pre = graph[r][c];
					if(visited[r][c]) {
						continue;
					}

					if (diff == 0) {
						continue;
					} else if (diff == -1) {
						if (rowChecker(r, c, 1)) {
							continue;
						}

						isOK = false;
						break;
					} else if (diff == 1) {
						if (rowChecker(r, c-1, 0)) {
							continue;
						}

						isOK = false;
						break;
					} else {
						isOK = false;
						break;
					}

				}

				if (isOK) {
					count++;
				}
			}
			
			visited = new boolean[N][N];
			// 세로 검사
			for (int c = 0; c < N; c++) {
				boolean isOK = true;
				int pre = graph[0][c];

				for (int r = 0; r < N; r++) {
					if (!isOK)
						break;

					int diff = graph[r][c] - pre;
					pre = graph[r][c];

					if (diff == 0) {
						continue;
					} else if (diff == -1) {
						if (colChecker(r, c, 3)) {
							continue;
						}

						isOK = false;
						break;
					} else if (diff == 1) {
						if (colChecker(r-1, c, 2)) {
							continue;
						}

						isOK = false;
						break;
					} else {
						isOK = false;
						break;
					}

				}

				if (isOK) {
					count++;
				}
			}

			System.out.printf("#%d %d%n", tc, count);
			// case end
		}

	}

	static boolean colChecker(int row, int col, int direction) {
		for (int i = 0; i < X; i++) {
			int nextR = row + i * dr[direction];
			if (isInBound(nextR, col) && graph[row][col] == graph[nextR][col] && !visited[nextR][col]) {
				visited[nextR][col] = true;
				continue;
				
			}
			return false;
		}
		return true;
	}

	static boolean rowChecker(int row, int col, int direction) {
		
		for (int i = 0; i < X; i++) {
			int nextC = col + i * dc[direction];
			if (isInBound(row, nextC) && graph[row][col] == graph[row][nextC] && !visited[row][nextC]) {
				visited[row][nextC] = true;
				continue;
			}
			
			return false;
		}
		return true;
	}

	static boolean isInBound(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
