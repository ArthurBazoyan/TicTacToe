package search;
import game.Action;
import game.State;
import game.TerminalTest;

import java.util.Map;


public interface Search
{
    Map<State, Action> findStrategy(State intialState, TerminalTest test);
    int get_states_generated();
}