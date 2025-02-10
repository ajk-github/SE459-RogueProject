package com.roguegame.GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.roguegame.Game;
import com.roguegame.elements.Dungeon;
import com.roguegame.elements.Player;

public class GamePanel extends JPanel implements KeyListener {
    private static final int TILE_SIZE = 16;
    private Game game;

    public GamePanel() {
        game = new Game(); 
        setPreferredSize(new Dimension(game.getCurrentDungeon().getWidth() * TILE_SIZE,
                game.getCurrentDungeon().getHeight() * TILE_SIZE));
        setFocusable(true);
        requestFocusInWindow(); // Add this to capture key events
        addKeyListener(this);
        setFont(new Font("Monospaced", Font.PLAIN, TILE_SIZE));
    }
    
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Dungeon dungeon = game.getCurrentDungeon();
    Player player = game.getPlayer();

    // Clear screen before drawing
    g.clearRect(0, 0, getWidth(), getHeight());

    // Draw the dungeon
    for (int y = 0; y < dungeon.getHeight(); y++) {
        for (int x = 0; x < dungeon.getWidth(); x++) {
            char tile = dungeon.getTile(x, y);
            g.drawString(String.valueOf(tile), x * TILE_SIZE, (y + 1) * TILE_SIZE);
        }
    }

    // Draw the player
    g.drawString(String.valueOf(player.getSymbol()), player.getX() * TILE_SIZE, (player.getY() + 1) * TILE_SIZE);
}

    

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
public void keyPressed(KeyEvent e) {
    int dx = 0, dy = 0;
    int key = e.getKeyCode();
    
    switch (key) {
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            dy = -1;
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            dy = 1;
            break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            dx = -1;
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            dx = 1;
            break;
        case KeyEvent.VK_V: // Move Down a Floor
            if (game.getCurrentDungeon().getTile(game.getPlayer().getX(), game.getPlayer().getY()) == 'v') {
                game.moveToNextFloor();
                System.out.println("Moved to Next Floor");
                repaint(); // Force screen update
            }
            break;
        case KeyEvent.VK_CIRCUMFLEX:
        case KeyEvent.VK_6: // Move Up a Floor
            if (game.getCurrentDungeon().getTile(game.getPlayer().getX(), game.getPlayer().getY()) == '^') {
                game.moveToPreviousFloor();
                System.out.println("Moved to Previous Floor");
                repaint(); // Force screen update
            }
            break;
    }
    
    if (dx != 0 || dy != 0) {
        game.getPlayer().move(dx, dy, game.getCurrentDungeon());
        repaint(); // Update screen after moving
    }
}


    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
}
