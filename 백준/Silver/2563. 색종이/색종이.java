import java.io.*;

public class Main {
    final static int paperWidth = 10;
    final static int paperHeight = 10;
    final static int gridSize = 100;
    static boolean[][] grid = new boolean[gridSize][gridSize]; //default is 'false'
    static int area = 0;


    public static void main(String[] args) throws IOException {
        //@todo  input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperAmount = Integer.parseInt(br.readLine());

        for (int i = 0; i < paperAmount; i++) {
            String[] lineInput = br.readLine().split(" ");
            int left = Integer.parseInt(lineInput[0]);
            int right = Integer.parseInt(lineInput[1]);

            checkGrid(left, right);
        }

        countArea();
        System.out.println(area);
    }

    //Checking Methods
    static void checkGrid(int left, int bottom) {
        for (int i = 0; i < paperHeight; i++) {
            checkRow(left + i, bottom);
        }
    }

    static void checkRow(int left, int bottom) {
        for (int i = 0; i < paperWidth; i++) {
            grid[left][bottom + i] = true;
        }
    }

    //Counting Methods
    static void countArea() {
        for (int row = 0; row < gridSize; row++){
            for (int column = 0; column < gridSize; column++) {
                countCell(grid[row][column]);
            }
        }
    }

    static void countCell(boolean checked) {
        if (checked) {
            area++;
        }
    }
}



