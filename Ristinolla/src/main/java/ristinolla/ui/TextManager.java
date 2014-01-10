/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ristinolla.logic.Game;

/**
 *
 * @author miro
 */
public class TextManager implements ActionListener {

    private final JButton j;
    private final Game _g;
    private int _x, _y;
    private JFrame _frame;

    /**
     * Takes a button object, game object, x and y values and the frame used
     */
    public TextManager(JButton j, Game _g, int x, int y, JFrame f) {
        this.j = j;
        this._g = _g;
        _x = x;
        _y = y;
        _frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_g.isGameWon()) {
            _g.resetBoard();
            
            JOptionPane.showMessageDialog(_frame,
                    "Game over, congrats! Winner:" + (_g.isPlayerTurn() ? "X" : "O"),
                    "Winner found!",
                    JOptionPane.PLAIN_MESSAGE);

            return;
        }
        System.out.println(_x + " " + _y);
        if (j.getText().isEmpty()) {
            j.setText(_g.isPlayerTurn() ? "X" : "O");
        }
        _g.turn(_x, _y);

    }

}
