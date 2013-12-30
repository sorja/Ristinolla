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

        checkWinningCondition(x, y);
        _playerTurn = !_playerTurn;

    }

//    public boolean isSquareOnTheEdge(Square s) {
//        //        Have to update square to make this work (get x/y)
//
//        return false;
//    }
    public GameBoard getGameBoard() {
        return _gB;
    }

    private void checkWinningCondition(int x, int y) {
        SquareState s = _playerTurn ? SquareState.CROSS : SquareState.CIRCLE;

    }

    private boolean isHorizontalWinning(SquareState s, int x, int y) {

        int sequence = 0;

        sequence = isWinningFromRight(s, x, y) ? 3 : 0;
        sequence = isWinningFromLeft(s, x, y) ? 3 : 0;
        sequence = isWinningFromMiddle(s, x, y) ? 3 : 0;

        if (x == 0) {

        }

        return sequence == 3;
    }

    private boolean isWinningFromRight(SquareState s, int x, int y) {
        if (x == _gB.getWidth() - 1) {
            if (_gB.getSquareAtXY(x - 1, y).getSquareState() == s && _gB.getSquareAtXY(x - 2, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromLeft(SquareState s, int x, int y) {
        if (x == 0) {
            if (_gB.getSquareAtXY(x + 1, y).getSquareState() == s && _gB.getSquareAtXY(x + 2, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromMiddle(SquareState s, int x, int y) {
        if (x != 0 && x != _gB.getWidth() - 1) {
            if (_gB.getSquareAtXY(x + 1, y).getSquareState() == s && _gB.getSquareAtXY(x - 1, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWinning(SquareState s) {
        return false;
    }

    private boolean isDiagonalWinning(SquareState s) {
        return false;
    }

}
