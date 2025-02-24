package com.roguegame;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.roguegame.elements.Floor;
import com.roguegame.elements.Monster;
import com.roguegame.elements.Player;
import com.roguegame.GUI.GameBoard;

import com.roguegame.utils.Functions;

public class Main {

	private static JFrame window;
	private static GameBoard gameBoard;
	
	public static void main(String[] args) {
		
		System.out.println("[Main]: Starting...");
		createWindow();
		createGameBoard();
		initGame();
	}
	
	private static void createWindow() {
		System.out.println("[Main]: Creating window");
		window = new JFrame("Ascii Rogue");
		window.setVisible(true);
		window.setResizable(false);
		window.setBounds(200, 80, Reference.windowWidth, Reference.windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void createGameBoard() {
		System.out.println("[Main]: Creating GameBoard");
		gameBoard = new GameBoard();
		window.add(gameBoard);
		gameBoard.requestFocusInWindow();
	}
	
	/**Starts a new game!*/
	public static void initGame() {
		//initialization
		Reference.currentFloor = new Floor(0);
		Reference.player = new Player(3, 2);
		Reference.monsters = new ArrayList<Monster>();
		
		Functions.initMovingTiles();
	}

}
