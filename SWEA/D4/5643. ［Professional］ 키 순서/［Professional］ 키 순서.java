

import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static List<Integer>[] edges;
	static int[] count;

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("./src/swea/_5643_키순서/sample_input (1).txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// case start
			N = sc.nextInt();
			int M = sc.nextInt();

			// 초기화
			edges = new List[N + 1];
			for(int i = 0; i <= N; i++) edges[i] = new ArrayList<>();
			count = new int[N + 1];
			
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edges[from].add(to);
			}

			for (int start = 1; start <= N; start++) {
				// 각 정점 별로 루트 탐색
				bfs(start);
			}

			int result = 0;
			
			for(int i = 1; i <= N; i++ ) {
				if(count[i] == N - 1)
					result++;
			}
			
			System.out.printf("#%d %d%n", tc, result);
		} // case end

	}// main end

	static void bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(start);
		visited[0] = visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int e : edges[cur]) {
				if(!visited[e]) {
					q.add(e);
					visited[e] = true;
					count[e] += 1;
					count[start] += 1;
				}
			}
		}
		
	}

}
