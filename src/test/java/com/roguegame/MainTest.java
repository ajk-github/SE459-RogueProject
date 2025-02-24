package com.roguegame;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.roguegame.elements.Monster;
import com.roguegame.elements.Floor;
import com.roguegame.elements.Player;
import com.roguegame.utils.Functions;

import java.util.ArrayList;

public class MainTest {

    @BeforeEach
    void setUp() {
        // Reset the game state before each test
        Reference.currentFloor = null;
        Reference.player = null;
        Reference.monsters = null;
    }

    @Test
    void testMonstersInitialization() {
        // Call the initGame method to start a new game
        Main.initGame();

        // Verify that the monsters list is initialized
        assertNotNull(Reference.monsters, "Monsters list should be initialized.");
        
        // Verify that the monsters list is empty at the start
        assertTrue(Reference.monsters.isEmpty(), "Monsters list should be empty at the start.");
    }
}
