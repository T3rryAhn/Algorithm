

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Edge {
        int start, end;
        long cost;

        Edge(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int[] rep;

    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("playground\\_1251_하나로\\re_sample_input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // case start
            int N = sc.nextInt();
            rep = new int[N];

            for (int i = 1; i < N; i++) {
                rep[i] = i;
            }

            int[][] nodes = new int[N][2];

            List<Edge> edges = new ArrayList<Edge>();

            for (int i = 0; i < N; i++) {
                nodes[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                nodes[i][1] = sc.nextInt();
            }

            double E = sc.nextDouble();

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    long x = nodes[i][0] - nodes[j][0];
                    long y = nodes[i][1] - nodes[j][1];
                    long d = x * x + y * y;
                    long w = d;

                    edges.add(new Edge(i, j, w));
                }
            }

            edges.sort(Comparator.comparingLong(o1 -> o1.cost));

            long total = 0;
            int pick = 0;
            for (Edge e : edges) {
                if (pick == N - 1) {
                    break;
                }

                if (find(e.start) == find(e.end)) {
                    continue;
                }
                pick++;
                union(e.start, e.end);

                total += e.cost;
            }

            long answer = Math.round(E * total);

            System.out.printf("#%d %d%n", tc, answer);
            // case end
        }

    }// main

    static void union(int a, int b) {
        rep[find(b)] = find(a);
    }

    static int find(int a) {
        if (rep[a] == a)
            return a;

        return rep[a] = find(rep[a]);
    }
}
