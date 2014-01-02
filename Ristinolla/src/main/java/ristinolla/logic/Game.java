package ristinolla.logic;

/**
 *
 * @author miro
 */
public class Game {

    private GameBoard _gameBoard;
    private boolean _playerTurn;

    /**
     * Setting gameboard and playerturn.
     * @param gB
     */
    public Game(GameBoard gB) {
        _gameBoard = gB;
        _playerTurn = false;
    }

    /**
     * Continues the game 1 turn forwards
     * @param x 
     * @param y 
     */
    public void turn(int x, int y) {

        if (_gameBoard.getSquareAtXY(x, y).getSquareState() != SquareState.EMPTY) {
            return;
        }

        if (_playerTurn) {
            _gameBoard.getSquareAtXY(x, y).setSquareState(SquareState.CROSS);
        } else {
            _gameBoard.getSquareAtXY(x, y).setSquareState(SquareState.CIRCLE);
        }

        checkWinningCondition(x, y);
        _playerTurn = !_playerTurn;

    }

//    public boolean isSquareOnTheEdge(Square s) {
//        //        Have to update square to make this work (get x/y)
//
//        return false;
//    }

    /**
     * Returns gameboard
     * @return
     */
        public GameBoard getGameBoard() {
        return _gameBoard;
    }

    private void checkWinningCondition(int x, int y) {
        SquareState s = _playerTurn ? SquareState.CROSS : SquareState.CIRCLE;

    }

    private boolean isHorizontalWinning(SquareState s, int x, int y) {

        int sequence = 0;

        sequence = isWinningFromRight(s, x, y) ? 3 : 0;
        sequence = isWinningFromLeft(s, x, y) ? 3 : 0;
        sequence = isWinningFromMiddleX(s, x, y) ? 3 : 0;

        return sequence == 3;
    }

    private boolean isWinningFromRight(SquareState s, int x, int y) {
        if (x == _gameBoard.getWidth() - 1) {
            if (_gameBoard.getSquareAtXY(x - 1, y).getSquareState() == s && _gameBoard.getSquareAtXY(x - 2, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromLeft(SquareState s, int x, int y) {
        if (x == 0) {
            if (_gameBoard.getSquareAtXY(x + 1, y).getSquareState() == s && _gameBoard.getSquareAtXY(x + 2, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromMiddleX(SquareState s, int x, int y) {
        if (x != 0 && x != _gameBoard.getWidth() - 1) {
            if (_gameBoard.getSquareAtXY(x + 1, y).getSquareState() == s && _gameBoard.getSquareAtXY(x - 1, y).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWinning(SquareState s, int x, int y) {
        int sequence = 0;

        sequence = isWinningFromBottom(s, x, y) ? 3 : 0;
        sequence = isWinningFromTop(s, x, y) ? 3 : 0;
        sequence = isWinningFromMiddleY(s, x, y) ? 3 : 0;

        return sequence == 3;
    }

    private boolean isWinningFromBottom(SquareState s, int x, int y) {
        if (y == _gameBoard.getHeight() - 1) {
            if (_gameBoard.getSquareAtXY(x, y - 1).getSquareState() == s && _gameBoard.getSquareAtXY(x, y - 2).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromTop(SquareState s, int x, int y) {
        if (y == 0) {
            if (_gameBoard.getSquareAtXY(x, y + 1).getSquareState() == s && _gameBoard.getSquareAtXY(x, y + 2).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromMiddleY(SquareState s, int x, int y) {
        if (y != 0 && y != _gameBoard.getHeight() - 1) {
            if (_gameBoard.getSquareAtXY(x, y + 1).getSquareState() == s && _gameBoard.getSquareAtXY(x, y - 1).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWinning(SquareState s, int x, int y) {
        int sequence = 0;

        sequence = isWinningFromBottomRight(s, x, y) ? 3 : 0;
        sequence = isWinningFromLeft(s, x, y) ? 3 : 0;
        sequence = isWinningFromMiddleX(s, x, y) ? 3 : 0;

        return sequence == 3;
    }

    private boolean isWinningFromBottomRight(SquareState s, int x, int y) {
        if (x == _gameBoard.getWidth() - 1 && y == _gameBoard.getHeight() - 1) {
            if (_gameBoard.getSquareAtXY(x, y - 1).getSquareState() == s && _gameBoard.getSquareAtXY(x, y - 2).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromTopLeft(SquareState s, int x, int y) {
        if (x == 0 && y == 0) {
            if (_gameBoard.getSquareAtXY(x + 1, y + 1).getSquareState() == s && _gameBoard.getSquareAtXY(x + 2, y + 2).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFromAnyMiddle(SquareState s, int x, int y) {
        if (y != 0 && y != _gameBoard.getHeight() - 1 && x != 0 && x != _gameBoard.getWidth() - 1) {
            if (_gameBoard.getSquareAtXY(x + 1, y + 1).getSquareState() == s && _gameBoard.getSquareAtXY(x - 1, y - 1).getSquareState() == s) {
                return true;
            }
        }
        return false;
    }
}
