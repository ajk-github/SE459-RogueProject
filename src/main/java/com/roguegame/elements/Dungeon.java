package com.roguegame.elements;

public class Dungeon {
    private int width;
    private int height;
    private char[][] map;
    private int startX;
    private int startY;

    public Dungeon(String[] mapData) {
        this.height = mapData.length;
        this.width = mapData[0].length();
        map = new char[height][width];
    
        for (int y = 0; y < height; y++) {
            if (mapData[y].length() != width) {
                throw new IllegalArgumentException("Inconsistent row width in dungeon data at line " + y + 
                                                   ". Expected: " + width + ", Found: " + mapData[y].length());
            }
            map[y] = mapData[y].toCharArray();
            for (int x = 0; x < width; x++) {
                if (map[y][x] == '@') {
                    startX = x;
                    startY = y;
                    map[y][x] = '.'; // Replace player symbol with floor tile
                    System.out.println("Player placed at: (" + startX + ", " + startY + ")");
                }
            }
        }
    
        // If the player wasn't found in the map, place them at a default walkable position
        if (startX == 0 && startY == 0) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (map[y][x] == '.') { // Find the first walkable space
                        startX = x;
                        startY = y;
                        System.out.println("No '@' found. Placing player at default: (" + startX + ", " + startY + ")");
                        return;
                    }
                }
            }
        }
    }
    

    public char getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return ' ';
        }
        return map[y][x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
