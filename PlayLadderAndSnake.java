// -----------------------------------------------------
// Assignment #1 - Snakes & Ladder: Part 1
// COMP-249: Object Oriented Programming II
// Written by: Safira Sari - 40249017
// Due Date: Friday, February 3rd, 2023
// -----------------------------------------------------

import java.util.Scanner;

/**
 * PlayLadderAndSnake is the driver class that calls on the method created in Player and LadderAndSnake class to initiate the game.
 * 
 * @author Safira Sari
 * @version 1.0
 * @see Player 
 * @see LadderAndSnake 
 */

public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		// Introducing the Scanner class
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nWelcome to the COMP-249 Snakes & Ladder game, created by Safira Sari!\n" 
						+ "_____________________________________________________________________\n");
		
		System.out.println("BEFORE WE START PLAYING...\n");
		System.out.print("Please enter the number of players: ");
		int userNumOfPlayers = input.nextInt();
		
		LadderAndSnake game = new LadderAndSnake(userNumOfPlayers);
		
		System.out.print("\nWould you like to change your player name?\n" + 
				"1. Yes, rename myself. \n" +
				"2. No, stick to default names. \n" +
				"Please type your answer (1 or 2): ");
		int userAnswer = input.nextInt();
		
		if (userAnswer == 1) {
			game.promptRename();
		} else {
			System.out.println("Default names kept.\n");
		}
		game.promptContinue();
		game.displayRules();
		
		
		game.decideTurnOrder();
		
		game.play();

		
		input.close();
		System.exit(0);
		
	}
	
	
}