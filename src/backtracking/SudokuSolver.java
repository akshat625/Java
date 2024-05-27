package backtracking;

public class SudokuSolver {

    public static boolean sudokuSolver(int[][] grid,int N){

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(grid[row][col]==0){
                    for (int num = 1; num <= N; num++) {
                        if(isValid(grid,row,col,num)){
                            grid[row][col]=num;

                            if (sudokuSolver(grid,N))
                                return true;

                            grid[row][col]=0;
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] grid, int row, int col, int num) {

        for (int i = 0; i < grid.length; i++) {
            if(grid[row][i]==num || grid[i][col]==num)
                return false;
        }

        int sqrtN= (int)Math.sqrt(grid.length);
        int startRow = row-row%sqrtN;
        int startCol = col-col%sqrtN;

        for (int i = 0; i < sqrtN; i++) {
            for (int j = 0; j < sqrtN; j++) {
                if(grid[i+startRow][j+startCol]==num)
                    return false;

            }

        }
        return true;
    }

    private static void printSudoku(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                System.out.print(grid[row][col] + " ");
                if ((col + 1) % Math.sqrt(grid.length) == 0 && col < grid.length - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((row + 1) % Math.sqrt(grid.length) == 0 && row < grid.length - 1) {
                for (int k = 0; k < grid.length * 2 + 3; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {

        int[][] sudokuGrid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int N=sudokuGrid.length;

        if(sudokuSolver(sudokuGrid,N))
            printSudoku(sudokuGrid);
        else
            System.out.println("Solution does not exist");
    }
}
