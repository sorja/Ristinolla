/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ristinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ristinolla.logic.Game;

public class TextManager implements ActionListener {

    private JButton j;
    private Game _g;
    private int x,y;
    
    public TextManager(JButton j, Game _g, int x, int y) {
        this.j = j;
        this._g = _g;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        _g.turn(x, y);
        j.setText(_g.isPlayerTurn() ? "X" : "O");
        
    }
    
}
