package com.roguegame;

import java.util.ArrayList;

import com.roguegame.elements.Floor;
import com.roguegame.elements.Monster;
import com.roguegame.elements.Player;

public class Reference {

	public static final int windowWidth = 1000;
	public static final int windowHeight = 600;
	
	public static final int floorCount = 5;
	
	public static Floor currentFloor;
	public static Player player;
	public static ArrayList<Monster> monsters;
}
