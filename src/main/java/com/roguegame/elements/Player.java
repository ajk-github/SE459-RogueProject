package com.roguegame.elements;

public class Player {
    private int x;
    private int y;
    private final char symbol = '@';

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(int dx, int dy, Dungeon dungeon) {
        int newX = x + dx;
        int newY = y + dy;
        char targetTile = dungeon.getTile(newX, newY);
    
        if (targetTile != '#') { // Allow movement on everything except walls
            x = newX;
            y = newY;
            System.out.println("Player moved to: (" + x + ", " + y + ")");
        } else {
            System.out.println("Blocked at: (" + newX + ", " + newY + ")");
        }
    }
    
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
