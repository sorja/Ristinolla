/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;

import ristinolla.logic.GameBoard;
import ristinolla.logic.SquareState;
import ristinolla.logic.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class GameTest {

    private Game _game;

    @Before
    public void setUp() {
        GameBoard g = new GameBoard(3, 3);
        _game = new Game(g);
    }

    @Test
    public void turnWorks() {
        _game.turn(1, 1);
        assertEquals(SquareState.CROSS, _game.getGameBoard().getSquareAtXY(1, 1).getSquareState());
    }

    @Test
    public void testWinningConditionHorizontal() {
        _game.turn(0, 0);
        _game.turn(0, 1);

        _game.turn(1, 0);
        _game.turn(0, 2);

        _game.turn(2, 0);

        assertEquals(_game.isGameWon(), true);
    }

    @Test
    public void testWinningConditionVertical() {
        _game.turn(0, 0);
        _game.turn(1, 1);

        _game.turn(0, 1);
        _game.turn(1, 2);

        _game.turn(0, 2);

        assertEquals(_game.isGameWon(), true);
    }

    @Test
    public void testWinningConditionDiagonalTopLeft() {
        _game.turn(1, 1);
        _game.turn(2, 0);

        _game.turn(0, 0);
        _game.turn(2, 1);

        _game.turn(2, 2);
        assertEquals(_game.isGameWon(), true);

    }

    @Test
    public void testWinningConditionDiagonalTopRight() {
        _game.turn(2, 0); //Top right
        _game.turn(0, 0);

        _game.turn(1, 1); //Middle
        _game.turn(2, 1);

        _game.turn(0, 2); //Bottom left
        assertEquals(_game.isGameWon(), true);

    }

    @Test
    public void returnIfAlreadyInPlace() {
        _game.turn(0, 1);
        _game.turn(0, 1);
        _game.turn(1, 1);
        assertEquals(_game.getGameBoard().getSquareAtXY(0, 1).getSquareState(), SquareState.CROSS);
    }
    
    @Test
    public void resetWorks(){
        _game.turn(0,1);
        _game.resetBoard();
        assertEquals(_game.getGameBoard().getSquareAtXY(0, 1).getSquareState(), SquareState.EMPTY);
    }
    
    @Test
    public void getIsPlayerTurn(){
        assertEquals(_game.isPlayerTurn(), true);
    }

}

