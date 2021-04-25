package com.main;

import game.Action;
import game.State;
import game.TerminalTest;
import search.MinimaxSearch;
import search.Search;
import tictactoe.Board;
import tictactoe.BoardTerminalTest;
import tictactoe.TicTacToePrinting;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is a demonstration of minimax search on tic-tac-toe");
        System.out.println();

        Board initialConfiguration = new Board(3, 3);
        TerminalTest terminalTest = new BoardTerminalTest(3);
        Search search = new MinimaxSearch();
        Map<State, Action> strategy = search.findStrategy(initialConfiguration, terminalTest);
        new TicTacToePrinting().printStrategy(strategy);
        //System.out.println(search.get_states_generated());
    }
}
