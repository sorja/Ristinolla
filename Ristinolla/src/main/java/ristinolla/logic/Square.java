
package ristinolla.logic;

/**
 *
 * @author miro
 */
public class Square {

    private SquareState _squareState;

    /**
     * Initializes the square state to empty
     */
    public Square() {
        _squareState = SquareState.EMPTY;
    }

    /**
     *
     * @return
     */
    public SquareState getSquareState() {
        return _squareState;
    }

    /**
     *
     * @param squareState
     */
    public void setSquareState(SquareState squareState) {
        _squareState = squareState;
    }

}
