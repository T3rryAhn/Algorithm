import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        Grid grid = new Grid();
        String result = "";


        for (int i = 0; i < 5; i++) {
            grid.putRowToGrid(inputView.readLine());
        }

        for (int i = 0; i < 15; i++) {
            result += readColumn(grid.getGrid(), i);
        }

        System.out.println(result);
    }

    static String readColumn(char[][] grid, int column) {
        String result = "";

        for (int i = 0; i < 5; i++) {
            if (grid[i][column] != '\u0000'){
                result += grid[i][column];

            }
        }
        return result.trim();
    }
}

class Grid {
    char[][] grid = new char[5][15];
    int rowCount = 0;

    void putRowToGrid(char[] row) {
        for (int i = 0; i < row.length; i++) {
            grid[rowCount][i] = row[i];
        }
        rowCount++;
    }

    char[][] getGrid() {
        return grid;
    }
}

class InputView {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    char[] readLine() throws IOException {
        String input = bufferedReader.readLine();
        return input.toCharArray();
    }
}


