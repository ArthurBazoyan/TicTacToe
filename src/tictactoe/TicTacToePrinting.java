package tictactoe;

import game.Action;
import game.Printing;
import game.State;

public class TicTacToePrinting extends Printing {
    public void print(Action action) {
        Mark mark = (Mark) action;
        System.out.print("mark (");
        System.out.print(mark.getRow() + ", ");
        System.out.print(mark.getColumn() + ")");
    }
    public void print(State state) {
        Board board = (Board) state;
        int height = board.getHeight();
        int width = board.getWidth();
        System.out.print('-');
        for (int col = 0; col < width; col++)
            System.out.print("----");
        System.out.println();
        for (int row = 0; row < height; row++) {
            System.out.print("|");
            for (int col = 0; col < width; col++) {
                int cell = board.getCell(row, col);
                char curr;
                if (cell == board.EMPTY)
                    curr = ' ';
                else if (cell == board.X)
                    curr = 'X';
                else // cell == board.O
                    curr = 'O';
                System.out.print(" " + curr + " |");
            }
            System.out.println();
            System.out.print('-');
            for (int col = 0; col < width; col++)
                System.out.print("----");
            System.out.println();
        }
    }
}
