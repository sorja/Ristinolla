/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBoardTest;

import logic.Square;
import logic.SquareState;
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
public class SquareTest {

    private Square _s;

    public SquareTest() {
    }

    @Before
    public void setUp() {
        _s = new Square();
    }

    @Test
    public void squareWorks() {
        
        assertEquals(_s.getSquareState(), SquareState.EMPTY);
    }

    @Test
    public void squareValueChangeWorks() {
        _s.setSquareState(SquareState.CROSS);
        assertEquals(_s.getSquareState(), SquareState.CROSS);
    }
}
