import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;

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
        char[][] grid = new char[N][N];
        char[][] grid_colorBlind = new char[N][N];

        for (int r = 0; r < N; r++) {
            String row = sc.next();
            grid[r] = row.toCharArray();

            for (int c = 0 ; c < N; c++ ) {
                grid_colorBlind[r][c] = grid[r][c] == 'G' ? 'R' : grid[r][c];
            }
        }

        int normal = countAreas(grid);
        int colorBlind = countAreas(grid_colorBlind);

        System.out.println(normal + " " + colorBlind);
    }

    static int countAreas(char[][] grid) {
        int count = 0;

        boolean[][] visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    count++;
                    floodFill(r, c, grid, visited);
                }
            }
        }

        return count;
    }

    static boolean isInBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void floodFill(int r, int c, char[][] grid, boolean[][] visited) {
        // init
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] { r, c });

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cr = curr[0];
            int cc = curr[1];
            char color = grid[cr][cc];

            for (int d = 0; d < dr.length; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (!isInBounds(nr, nc)) continue;
                if (visited[nr][nc]) continue;

                char nextColor = grid[nr][nc];
                if (color != nextColor) continue;

                visited[nr][nc] = true;
                stack.push(new int[] { nr, nc });
            }
        }

    }

}
