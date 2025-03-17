package com.roguegame.utils;

public enum Tile {

	NOTHING('.'),
	WALL('#'),
	PLAYER('@'),
	STAIRS('^'),
	TRAP('.'),
	HP_POTION('P'),
	GOLD('G'),
	TREASURE('.'),
	KEY('K'),
	DOOR('.'),
	MONSTER('M');
	
	private char symbol;
	
	Tile(char symbol) {
		this.symbol=symbol;
	}
	
	public char symbol() {return symbol;}
}
