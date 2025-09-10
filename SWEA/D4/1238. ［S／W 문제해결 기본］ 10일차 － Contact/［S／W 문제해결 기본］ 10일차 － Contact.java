

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static List<Integer>[] edges;
    static boolean[] visited;
    static final int N = 100 + 1;

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("playground\\_1238_contact\\input (2).txt");  
        //Scanner sc = new Scanner(file);      
        Scanner sc = new Scanner(System.in);      

        
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            // case start
            visited = new boolean[N];
            edges = new List[N];
            
            for(int i = 0; i < N; i++ ) {
                edges[i] = new ArrayList<>();
            }

            int dataLen = sc.nextInt();
            int start = sc.nextInt();

            for(int i = 0; i < dataLen / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                edges[from].add(to);
            }

            int answer = bfs(start);


            System.out.printf("#%d %d%n", tc, answer);

            // case end
        }
    }// main

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;

        int lastMax = start;

        while(!q.isEmpty()) {
            int size = q.size();
            int max = -1;

            for(int i = 0; i < size; i++) {
                int curr = q.poll();

                for(int n : edges[curr]) {
                    if(!visited[n]) {
                        q.add(n);
                        visited[n] = true;
                        max = Math.max(max, n);
                    }
                }
            }

            if(max != -1)
                lastMax = max;
        }
        return lastMax;
    }
}
