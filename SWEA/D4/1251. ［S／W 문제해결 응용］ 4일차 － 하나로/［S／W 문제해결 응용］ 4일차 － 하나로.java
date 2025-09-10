

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static boolean[] visited;
	static long[] minCost;
	static long[] xs, ys;

	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src/swea/_1251_하나로_프림/re_sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// case start
			N = sc.nextInt();

			// 초기화
			visited = new boolean[N];
			xs = new long[N];
			ys = new long[N];
			minCost = new long[N];
			Arrays.fill(minCost, INF);

			// input
			for (int i = 0; i < N; i++) {
				xs[i] = sc.nextLong();
			}
			for (int i = 0; i < N; i++) {
				ys[i] = sc.nextLong();
			}
			double E = sc.nextDouble();

			long sum = prim(0);
			long answer = Math.round(sum * E);
			
			System.out.printf("#%d %d%n", tc, answer);
			// case end
		}

	}

	static long prim(int start) {
		minCost[start] = 0;
		long sum = 0;

		for (int i = 0; i < N; i++) {
			int u = -1;
			long min = INF;
			for (int v = 0; v < N; v++) {
				// MST에 아직 안 들어간 정점 중에서 값이 제일 작은 정점 u 선택
				if (!visited[v] && minCost[v] < min) {
					min = minCost[v];
					u = v;
				}
			}

			// u 를 mst에 포함
			visited[u] = true;
			sum += minCost[u];

			for (int v = 0; v < N; v++) {
				if (!visited[v]) {
					long w = dist2(u, v);
					if (w < minCost[v]) {
						minCost[v] = w;
					}
				}
			}
		}
		
		return sum;

	}

	static long dist2(int a, int b) {
		long dx = xs[a] - xs[b];
		long dy = ys[a] - ys[b];
		return dx * dx + dy * dy;
	}

}
