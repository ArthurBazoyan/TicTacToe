package tictactoe;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import game.Action;
import game.Player;
import game.State;

public class Board implements State {
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;

    private final int height;
    private final int width;
    private final int[] board;
    private final Player player;


    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new int[height * width];
        Arrays.fill(board, EMPTY);
        player = Player.MAX;
    }
    private Board(int height, int width, int[] board, Player player) {
        this.height = height;
        this.width = width;
        this.board = board;
        this.player = player;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getCell(int row, int col) {
        return board[row * width + col];
    }
    public Player getPlayer() {
        return player;
    }
    public Set<Action> getApplicableActions() {
        Set<Action> actions = new LinkedHashSet<Action>();
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                if (board[row * width + col] == EMPTY) {
                    Mark mark = new Mark(row, col);
                    actions.add(mark);
                }
        return actions;
    }
    public State getActionResult(Action action) {
        Mark mark = (Mark) action;
        int[] newBoard = board.clone();
        if (player == Player.MAX) {
            newBoard[mark.getRow() * width + mark.getColumn()] = X;
            return new Board(height, width, newBoard, Player.MIN);
        } else { // player == Player.MIN
            newBoard[mark.getRow() * width + mark.getColumn()] = O;
            return new Board(height, width, newBoard, Player.MAX);
        }
    }


    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(board);
        result = prime * result + height;
        result = prime * result + ((player == null) ? 0 : player.hashCode());
        result = prime * result + width;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Board other = (Board) obj;
        if (!Arrays.equals(board, other.board))
            return false;
        if (height != other.height)
            return false;
        if (player != other.player)
            return false;
        if (width != other.width)
            return false;
        return true;
    }
}
