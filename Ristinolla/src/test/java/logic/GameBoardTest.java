package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.GameBoard;
import logic.Square;

/**
 *
 * @author miro
 */
public class GameBoardTest {
    private GameBoard _gB;
    public GameBoardTest() {
    }

    
    @Before
    public void setUp() {
        _gB = new GameBoard(3,3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isSizeRight(){
        assertEquals(_gB.getSquares().length, 3*3);
    }
    
    @Test
    public void isHeightCorrect(){
        assertEquals(_gB.getHeight(), 3);
    }
    
    @Test
    public void isWidthCorrect(){
        assertEquals(_gB.getWidth(), 3);
    }
    
    @Test
    public void isGetSquareRight(){
        Square sq = _gB.getSquareAtXY(1, 1);
        Square[] squares = _gB.getSquares();
        assertEquals(squares[4], sq);
    }
}
