import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static char[][] graph;

    // directions
    // up, right, down, left
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    
    static int normalCount;
    static int colorBlindCount;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        // init graph
        graph = new char[N][N];
        for (int r = 0; r < N; r++) {
            String row = sc.next();
            graph[r] = row.toCharArray();
        }

        normalCount = 0;
        colorBlindCount = 0;

        countBlocks();

        System.out.println(normalCount + " " + colorBlindCount);
    }
    
    static void countBlocks() {
        // count block by normer person vision
        boolean[][] visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    normalCount++;
                }
                dfs(r, c, visited);
            }
        }
    
        // count block by color blind vision
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    colorBlindCount++;
                }
                dfs_colorBlind(r, c, visited);
            }
        }
    
    }

    static boolean isInBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    
    /*
     * method for normal person's vision
     */
    static void dfs(int r, int c, boolean[][] visited) {
        // init
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] { r, c });

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cr = curr[0];
            int cc = curr[1];
            visited[cr][cc] = true;
            char color = graph[cr][cc];

            for (int d = 0; d < dr.length; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if (!isInBounds(nr, nc))
                continue;
                if (visited[nr][nc])
                continue;

                char nextColor = graph[nr][nc];
                if (color != nextColor)
                    continue;

                stack.push(new int[] { nr, nc });
            }
        }

    }

    /*
     * method for color blind person's vision
     */
    static void dfs_colorBlind(int r, int c, boolean[][] visited) {
        // init
        Stack<int[]> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('R', 'R');
        map.put('G', 'R');
        map.put('B', 'B');

        stack.push(new int[] { r, c });

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cr = curr[0];
            int cc = curr[1];
            visited[cr][cc] = true;
            char color = map.get(graph[cr][cc]);

            for (int d = 0; d < dr.length; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (!isInBounds(nr, nc))
                    continue;
                if (visited[nr][nc])
                    continue;

                char nextColor = map.get(graph[nr][nc]);
                if (color != nextColor)
                    continue;

                stack.push(new int[] { nr, nc });
            }
        }

    }

}
