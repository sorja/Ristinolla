package ristinolla.logic;

/**
 *
 * @author miro
 */
public class GameBoard {

    private Square[] _squares;
    private int _height;
    private int _width;

    /**
     *
     * @param height of the game board
     * @param width of the game woard
     */
    public GameBoard(int height, int width) {
        _height = height;
        _width = width;
        createSquares(height, width);
    }

    private void createSquares(int height, int width) {
        _squares = new Square[width * height];

        for (int i = 0; i < _squares.length; i++) {
            _squares[i] = new Square();
        }

    }

    /**
     *
     * @return
     */
    public Square[] getSquares() {
        return _squares;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return _height;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return _width;
    }
    
    /**
     * Returns a square at given values
     */
    public Square getSquareAtXY(int x, int y){
        return _squares[y * _width + x];
    }


    
    

}
