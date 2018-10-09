/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import tictactoe.gui.controller.TicTacViewController;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    TicTacViewController tictac = new TicTacViewController(); 
    int counter = 0;
    int winner = 0;
    private boolean tie = false;
    int[][] dataBoard = new int[3][3];
    //public IGameModel game;
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {   
        if(counter%2 == 0)
        {
           counter = 0;            
        }
        return counter;     
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    
    public boolean play(int col, int row)
    {
        if(dataBoard[col][row] >= 1)
        {
            return false;
        }
        dataBoard[col][row] = counter + 1;
        counter ++;
        checkForWinner();
        checkTie();
        return true;
    }
    
    public boolean checkTie()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(dataBoard[i][j] == 0)
                {
                    return false;
                }
            }
        }
        tie = true;
        return tie;
    }

    public boolean isGameOver()
    {
        if (tie == true || winner > 0) 
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }
    
    public void checkForWinner()
    {
        if (dataBoard[0][0] == 1 && dataBoard[0][1] == 1 && dataBoard[0][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[1][0] == 1 && dataBoard[1][1] == 1 && dataBoard[1][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[2][0] == 1 && dataBoard[2][1] == 1 && dataBoard[2][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[0][0] == 1 && dataBoard[1][1] == 1 && dataBoard[2][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[0][2] == 1 && dataBoard[1][1] == 1 && dataBoard[2][0] == 1)
        {
            winner = 1;
        }
        if (dataBoard[0][0] == 1 && dataBoard[1][0] == 1 && dataBoard[2][0] == 1)
        {
            winner = 1;
        }
        if (dataBoard[1][0] == 1 && dataBoard[1][1] == 1 && dataBoard[1][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[2][0] == 1 && dataBoard[2][1] == 1 && dataBoard[2][2] == 1)
        {
            winner = 1;
        }
        if (dataBoard[0][0] == 2 && dataBoard[0][1] == 2 && dataBoard[0][2] == 2)
        {
            winner = 2;
        }
        if (dataBoard[1][0] == 2 && dataBoard[1][1] == 2 && dataBoard[1][2] == 2)
        {
            winner = 2;
        }
        if (dataBoard[2][0] == 2 && dataBoard[2][1] == 2 && dataBoard[2][2] == 2)
        {
            winner = 2;
        }
        if (dataBoard[0][0] == 2 && dataBoard[1][1] == 2 && dataBoard[2][2] == 2)
        {
            winner = 2;
        }
        if (dataBoard[0][2] == 2 && dataBoard[1][1] == 2 && dataBoard[2][0] == 2)
        {
            winner = 2;
        }
        if (dataBoard[0][0] == 2 && dataBoard[1][0] == 2 && dataBoard[2][0] == 2)
        {
            winner = 2;
        }
        if (dataBoard[1][0] == 2 && dataBoard[1][1] == 2 && dataBoard[1][2] == 2)
        {
            winner = 2;
        }
        if (dataBoard[2][0] == 2 && dataBoard[2][1] == 2 && dataBoard[2][2] == 2)
        {
            winner = 2;
        }
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if (tie == true)
        {
            return -1;
        }
        else
        {
            return winner;
        }
    }
    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        counter = 0;
        dataBoard = new int[3][3];
        tie = false;
        winner = 0;
    }

}
