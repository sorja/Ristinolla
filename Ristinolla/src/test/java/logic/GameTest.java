/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

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
        assertEquals(SquareState.CIRCLE, _game.getGameBoard().getSquareAtXY(1, 1).getSquareState());
    }
}
