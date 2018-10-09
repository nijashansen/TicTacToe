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
        return true;
    }

    public boolean isGameOver()
    {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        // check for row winners
        for (int row = 0; row < dataBoard.length; row++) 
        {
        // if all three columns are the same then that player wins!
            if (dataBoard[0][0] == dataBoard[0][1] && dataBoard[0][1] == dataBoard[row][2]) 
            {
                // return the winner!
                return dataBoard[row][0];
            }
        }

        // check for column winners
        for (int col = 0; col < dataBoard.length; col++)
        {
        // if all three rows are the same then that player wins!
            if (dataBoard[0][col] == dataBoard[1][col] && dataBoard[1][col] == dataBoard[2][col]) 
            {
                // return our winner!
                return dataBoard[0][col];
            }
        }

        // check for diag winners
        if (dataBoard[0][0] == dataBoard[1][1] && dataBoard[1][1] == dataBoard[2][2]) 
        {
            return dataBoard[0][0];
        }

        if (dataBoard[0][2] == dataBoard[1][1] && dataBoard[1][1] == dataBoard[2][0])
        {
            return dataBoard[0][2];
        }

        // otherwise just return an empty character
        return ' ';
        //return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        dataBoard = new int[3][3];
    }

}
