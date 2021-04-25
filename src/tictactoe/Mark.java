package tictactoe;

import game.Action;

public class Mark implements Action {
    private final int row;
    private final int col;

    public Mark(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return col;
    }
}
