

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
//		File file = new File("./src/swea/_1267_작업순서/sample_input (2).txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			// case start
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int[] inDegree = new int[V + 1];
			List<Integer>[] edges = new ArrayList[V + 1]; 
			for(int i = 1; i < V + 1; i++) edges[i] = new ArrayList<>();
			
			for(int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edges[from].add(to);
				inDegree[to]++;
			}
			
			
			StringBuilder sb = new StringBuilder();
			
			// 위상정렬
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i <= V; i++) {
				if(inDegree[i] == 0)
					q.add(i);
			}
			
			
			while(!q.isEmpty()) {
				int v = q.poll();
				sb.append(v + " ");
				
				
				for(int e : edges[v]) {
					inDegree[e]--;
					
					if(inDegree[e] == 0) {
						q.add(e);
					}

				}
			}
			
			System.out.printf("#%d %s%n", tc, sb);
			
			
			// case end
		}
	}

}
