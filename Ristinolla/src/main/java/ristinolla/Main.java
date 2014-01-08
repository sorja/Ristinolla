package ristinolla;

import ristinolla.logic.Game;
import ristinolla.logic.GameBoard;
import ristinolla.ui.Ui;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Game g = new Game(new GameBoard(3, 3));
        Ui u = new Ui(g);
        u.run();
    }
}
