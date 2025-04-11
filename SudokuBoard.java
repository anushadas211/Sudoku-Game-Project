
package myjava.sudokuproject;

public class SudokuBoard {
  private SudokuCell[][] board = new SudokuCell[9][9];

    public SudokuBoard(int[][] puzzle) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = new SudokuCell(puzzle[i][j], puzzle[i][j] == 0);
    }

    public boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == num || board[i][col].getValue() == num)
                return false;
        }
        int r = (row / 3) * 3, c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j].getValue() == num) return false;
        return true;
    }
   public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].getValue() == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col].setValue(num);
                            if (solve()) return true;
                            board[row][col].setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public SudokuCell[][] getBoard() { return board; }
}

