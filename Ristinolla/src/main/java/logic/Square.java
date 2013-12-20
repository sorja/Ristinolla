
package logic;

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
