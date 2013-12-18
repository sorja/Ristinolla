/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

public class Square {

    private SquareState _squareState;

    public Square() {
        _squareState = SquareState.EMPTY;
    }

    public SquareState getSquareState() {
        return _squareState;
    }

    public void setSquareState(SquareState squareState) {
        _squareState = squareState;
    }

}
