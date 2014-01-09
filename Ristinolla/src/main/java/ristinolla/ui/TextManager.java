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

public class TextManager implements ActionListener {

    private final JButton j;
    private final Game _g;
    private int _x, _y;
    private JFrame _frame;

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
           JOptionPane.showMessageDialog(_frame,
                "Reset the game by pressing OK",
                "Reset",
                JOptionPane.PLAIN_MESSAGE);
            _g.resetBoard();
            
            
            return;
        }
        System.out.println(_x + " " + _y);
        if (j.getText().isEmpty()) {
            j.setText(_g.isPlayerTurn() ? "X" : "O");
        }
        _g.turn(_x, _y);    
        
    }

}
