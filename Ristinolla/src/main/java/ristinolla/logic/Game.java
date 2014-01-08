package ristinolla.logic;

/**
 *
 * @author miro
 */
public class Game {

    private GameBoard _gameBoard;
    private boolean _playerTurn;
    private boolean _gameWon;

    /**
     * Setting gameboard and playerturn.
     *
     * @param gB : Setting up a gameboard
     */
    public Game(GameBoard gB) {
        _gameBoard = gB;
        _playerTurn = true;
        _gameWon = false;
    }

    /**
     * Continues the game 1 turn forwards
     *
     * @param x taking a value on x axis
     * @param y taking a value on y axis
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

        if (checkWinningCondition(x, y)) {
            System.out.println("Winner!");
            _gameWon = true;
            return;
        }
        _playerTurn = !_playerTurn;
//        if (_gameWon) {
//            printGameBoard();
//        }
        System.out.println(_gameBoard.getSquareAtXY(x, y).getSquareState());
    }

    /**
     * Returns gameboard
     *
     * @return returns gameboard used
     */
    public GameBoard getGameBoard() {
        return _gameBoard;
    }

    private boolean checkWinningCondition(int x, int y) {
        SquareState s = _playerTurn ? SquareState.CROSS : SquareState.CIRCLE;

        return isWinningHorizontally(s, x, y) || isVerticalWinning(s, x, y) || isDiagonalWinning(s, x, y);
    }

    private boolean isWinningHorizontally(SquareState s, int x, int y) {
        boolean winning = true;

        if (x == _gameBoard.getWidth() - 1) {
            for (int i = 1; i < 3; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x - i, y).getSquareState() == s);
            }
        } else if (x == 0) {
            for (int i = 1; i < 3; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x + i, y).getSquareState() == s);
            }
        } else {
            for (int i = -1; i < 2; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x + i, y).getSquareState() == s);
            }
        }

        return winning;
    }

    private boolean isVerticalWinning(SquareState s, int x, int y) {
        boolean winning = true;

        if (y == _gameBoard.getHeight() - 1) {
            for (int i = 1; i < 3; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x, y - i).getSquareState() == s);
            }
        } else if (y == 0) {
            for (int i = 1; i < 3; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x, y + i).getSquareState() == s);
            }
        } else {
            for (int i = -1; i < 2; i++) {
                winning = winning && (_gameBoard.getSquareAtXY(x, y + i).getSquareState() == s);
            }
        }
        return winning;
    }

    private boolean isDiagonalWinning(SquareState s, int x, int y) {
//        boolean winning = true;
//        if (x == 0 && y == 0 && y + 2 < _gameBoard.getHeight() && x + 2 < _gameBoard.getWidth()) {
//
//            for (int i = 1; i < 3; i++) {
//                winning = winning && (_gameBoard.getSquareAtXY(x + i, y + i).getSquareState() == s);
//            }
//        } else if (y == _gameBoard.getHeight() - 1 && x == _gameBoard.getWidth() - 1
//                && x - 2 > 0 && y - 2 > 0) {
//            for (int i = 1; i < 3; i++) {
//
//                winning = winning && (_gameBoard.getSquareAtXY(x - i, y - i).getSquareState() == s);
//
//            }
//        } else if (y - 1 > 0 && x - 1 > 0 && y + 1 < _gameBoard.getHeight() && x + 1 < _gameBoard.getWidth()) {
//            for (int i = -1; i < 2; i++) {
//
//                winning = winning && (_gameBoard.getSquareAtXY(x + i, y + i).getSquareState() == s);
//            }
//        } else {
//            return false;
//        }
//        return winning;
        int i = 0;
        for (int yi = 0; yi < _gameBoard.getHeight() - 1; yi++) {
            for (int xi = 0; xi < _gameBoard.getWidth() - 1; xi++) {
                if (_gameBoard.getSquareAtXY(xi, yi).getSquareState() == s) {
                    i++;
                    if (xi + 1 < _gameBoard.getWidth()
                            && yi + 1 < _gameBoard.getHeight()
                            && _gameBoard.getSquareAtXY(xi + 1, yi + 1).getSquareState() != s) {
                        i = 0;
                    }
                    
                }
            }
        }
        return i == 3;
    }

    public boolean isGameWon() {
        return _gameWon;
    }

    public boolean isPlayerTurn() {
        return _playerTurn;
    }

    public void resetBoard() {
        for (int x = 0; x < _gameBoard.getWidth(); x++) {
            for (int y = 0; y < _gameBoard.getHeight(); y++) {
                if (_gameBoard.getSquareAtXY(x, y).getSquareState() != SquareState.EMPTY) {
                    _gameBoard.getSquareAtXY(x, y).setSquareState(SquareState.EMPTY);
                }

            }

        }
    }

    private void printGameBoard() {
        String dd = "";
        for (int x = 0; x < _gameBoard.getWidth(); x++) {
            for (int y = 0; y < _gameBoard.getHeight(); y++) {
                if (_gameBoard.getSquareAtXY(x, y).getSquareState() == SquareState.CIRCLE) {
                    System.out.print("O");

                } else if (_gameBoard.getSquareAtXY(x, y).getSquareState() == SquareState.CIRCLE) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
    }

}
