package gameboard;

public class GameBoard {

    private Square[] _squares;
    private int _height;
    private int _width;

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

    public Square[] getSquares() {
        return _squares;
    }

    public int getHeight() {
        return _height;
    }

    public int getWidth() {
        return _width;
    }
    
    public Square getSquareAtXY(int x, int y){
        return _squares[y * _width + x];
    }

}
