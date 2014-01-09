/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import ristinolla.logic.Game;

public class UI implements Runnable {

    private JFrame frame;
    private Game _game;

    public UI(Game game) {
        this._game = game;
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

        for (int y = 0; y < _game.getGameBoard().getWidth(); y++) {
            for (int x = 0; x < _game.getGameBoard().getHeight(); x++) {
                JButton j = new JButton();
                TextManager t = new TextManager(j, _game, x, y, frame);
                j.addActionListener(t);
                j.setFont(new Font("Dialog", 1, 70));
                j.setOpaque(true);
                j.setBackground(Color.white);
                container.add(j);
                System.out.println("button " + x + y + "done");

            }

        }

        

    }

}
