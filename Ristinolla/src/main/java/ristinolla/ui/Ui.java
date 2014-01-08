/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ristinolla.logic.Game;

public class Ui implements Runnable {

    private JFrame frame;
    private Game _game;

    public Ui(Game gameBoard) {
        this._game = gameBoard;
    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(
                300 * _game.getGameBoard().getWidth(),
                300 * _game.getGameBoard().getHeight()));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(_game.getGameBoard().getWidth(), _game.getGameBoard().getHeight()));

        for (int i = 0; i < _game.getGameBoard().getHeight() * _game.getGameBoard().getWidth(); i++) {

            JButton j = new JButton(i + "");
            TextManager t = new TextManager(j, _game);
            j.addActionListener(t);
            container.add(j);

        }

        MouseListener m = new MouseListener();
    }

}
