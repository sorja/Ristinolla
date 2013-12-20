package logic;

public class Game {

    private GameBoard _gB;
    private boolean _playerTurn;

    public Game(GameBoard gB) {
        _gB = gB;
        _playerTurn = false;
    }

    public void turn(int x, int y) {

        if (_gB.getSquareAtXY(x, y).getSquareState() != SquareState.EMPTY) {
            return;
        }

        if (_playerTurn) {
            _gB.getSquareAtXY(x, y).setSquareState(SquareState.CROSS);
        } else {
            _gB.getSquareAtXY(x, y).setSquareState(SquareState.CIRCLE);
        }
        update();
    }

    public void update() {
        int sequence = 0;
    }

    public boolean isSquareOnTheEdge(Square s) {
        //        Have to update square to make this work (get x/y)

        return false;
    }

    public GameBoard getGameBoard() {
        return _gB;
    }
    
    

}
