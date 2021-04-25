package tictactoe;

import game.State;
import game.TerminalTest;
import game.Player;

public class BoardTerminalTest extends TerminalTest {
    private final int k;	// number of "x" or "o" needed for a player to win

    public BoardTerminalTest(int k)
    {
        this.k = k;
    }


    public boolean checker(String string, State state)
    {
        Player player = state.getPlayer();
        char chr;
        int count = 0;

        // finding which player may win with his current move
        if(player ==  Player.MAX)
            chr = '1';
        else
            chr = '2';

        for(int i = 0; i < string.length(); ++i)
        {
            if( string.charAt(i) == chr)
            {
                count++;
                if( count == k )
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }
        return false;
    }


    public boolean isTerminal(State state)
    {

        // loop through, so MAX is "x" and MIN is "o"
        String str_check = "";
        boolean tick = false;

        // checking vertically
        for(int i = 0; i < ((Board)state).getHeight(); ++i)
        {
            for(int j = 0; j < ((Board)state).getWidth(); ++j)
            {
                str_check += ((Board)state).getCell(i, j);
                if(((Board)state).getCell(i, j) == 0)
                    tick = true;
            }
            if(checker(str_check, state))
            {
                if(str_check.charAt(0) == '1')
                {
                    utilities.put(state, 1);
                }
                else
                {
                    utilities.put(state, -1);
                }
                return true;
            }
            else
            {
                str_check = "";
            }
        }
        str_check = "";


        // checking horizontally
        for(int i = 0; i < ((Board)state).getWidth(); ++i)
        {
            for(int j = 0; j < ((Board)state).getHeight(); ++j)
            {
                str_check += ((Board)state).getCell(j, i);
                if(((Board)state).getCell(j, i) == 0)
                    tick = true;
            }
            if(checker(str_check, state))
            {
                if(str_check.charAt(0) == '1')
                {
                    utilities.put(state, 1);
                }
                else
                {
                    utilities.put(state, -1);
                }
                return true;
            }
            else
            {
                str_check = "";
            }
        }
        str_check = "";

        // checking diagonally

        for(int i = 0; i < ((Board)state).getWidth(); ++i )
        {
            str_check += ((Board)state).getCell(i, i);
            if(((Board)state).getCell(i, i) == 0)
                tick = true;
        }

        if(checker(str_check, state))
        {
            if(str_check.charAt(0) == '1')
            {
                utilities.put(state, 1);
            }
            else
            {
                utilities.put(state, -1);
            }
            return true;
        }

        str_check = "";

        int i = 0;
        int j = ((Board)state).getWidth();
        while(i < ((Board)state).getHeight() && j > 0)
        {
            str_check += ((Board)state).getCell(i, j);
            if(((Board)state).getCell(i, j) == 0)
                tick = true;
            j--;
            i++;
        }

        if(checker(str_check, state))
        {
            if(str_check.charAt(0) == '1')
            {
                utilities.put(state, 1);
            }
            else
            {
                utilities.put(state, -1);
            }
            return true;
        }


        if(!tick)
        {
            utilities.put(state, 0);
            return true;
        }
        return false;
    }
}
