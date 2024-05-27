package backtracking;

public class NQueens {
    private char[][] board;
    private int N;

    public NQueens(int N) {
        this.N = N;
        this.board = new char[N][N];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 'x';
            }
        }
    }

    public void solve() {
        placeQueens(0);
    }

    private void placeQueens(int row) {
        if(row==N) {
            printBoard();
            System.out.println("------------------------");
            return ;
        }
        for (int i = 0; i < N; i++) {
            if(isSafe(row,i)){
                board[row][i]='Q';

                placeQueens(row+1);

                board[row][i]='x';
            }

        }

    }

    private boolean isSafe(int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q')
                    return false;
        }

        // Check if there is a queen in the upper-left diagonal
        for(int i=row, j=col;i>=0 && j>=0; i--,j--){
            if (board[i][j]=='Q')
                return false;

        }


        // Check if there is a queen in the upper-right diagonal
        for(int i=row,j=col;i>=0 && j<N;i--,j++){
            if (board[i][j]=='Q')
                return false;
        }

        return true; // If no conflicts are found, the placement is safe
    }

    private void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < N; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < N; j++) {
                char symbol = (board[i][j] == 'Q') ? '\u2655' : '-';
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N for different board sizes
        NQueens nQueens = new NQueens(N);
        nQueens.solve();

    }
}

