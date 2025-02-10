package com.roguegame;

import javax.swing.JFrame;
import com.roguegame.GUI.GamePanel;

public class RogueGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ascii Roguelike");
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }
}
