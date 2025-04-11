
package myjava.sudokuproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SudokuGUI {
    private static SudokuBoard board;
    private static JTextField[][] grid = new JTextField[9][9];

    public static void main(String[] args) {
        int[][] puzzle = {
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
        board = new SudokuBoard(puzzle);

        JFrame frame = new JFrame("Sudoku");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(9, 9));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                JTextField field = new JTextField();
                field.setHorizontalAlignment(JTextField.CENTER);
                if (board.getBoard()[i][j].getValue() != 0) {
                    field.setText(String.valueOf(board.getBoard()[i][j].getValue()));
                    field.setEditable(false);
                } else {
                    field.setEditable(true);
                }
                grid[i][j] = field;
                frame.add(field);
            }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener((ActionEvent e) -> {
            if (board.solve()) updateBoard();
        });
frame.add(solveButton);
        frame.setVisible(true);
    }

    public static void updateBoard() {
        SudokuCell[][] solvedBoard = board.getBoard();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                grid[i][j].setText(String.valueOf(solvedBoard[i][j].getValue()));
                grid[i][j].setEditable(false);
            }
    }
}