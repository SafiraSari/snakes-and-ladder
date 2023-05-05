// -----------------------------------------------------
// Snakes & Ladder
// COMP-249: Object Oriented Programming II
// Written by: Safira Sari
// Date: Friday, February 3rd, 2023
// -----------------------------------------------------

import java.util.Random;
import java.util.Scanner;

/**
 * The LadderAndSnake class implements methods to create the game of Snakes and Ladder.
 *
 * @author Safira Sari
 * @version 1.0
 * @see Player 
 */

public class LadderAndSnake {

	// ATTRIBUTES
	private int numOfPlayers;
	
	private int[][] board = 
	{{37,0,0,10,0,0,0,0,22,0},		// Row 1, Positions 1 - 10
	{0,0,0,0,-10,0,0,0,0,0},		// Row 2, Positions 20 - 11
	{21,0,0,0,0,0,0,56,0,0}, 		// Row 3, Positions 21 - 30
	{0,0,0,0,8,0,0,0,0,0},			// Row 4, Positions 40 - 31
	{0,0,0,0,0,0,0,-18,0,0},		// Row 5, Positions 41 - 50
	{0,0,0,0,0,0,0,0,0,16},			// Row 6, Positions 60 - 51
	{0,0,0,-4,0,0,0,0,0,0},			// Row 7, Positions 61 - 70
	{20,0,0,0,0,0,0,0,-60,20},		// Row 8, Positions 80 - 71
	{0,0,0,0,0,0,0,0,0,0},			// Row 9, Positions 81 - 90
	{0,0,-20,-21,0,-71,0,-25,0,0}};		// Row 10, Positions 100 - 91
	// number on the board indicates the change to the current position
	// 0 = position remains, positive # = ladder (go up x amount of cells), negative # = means snake (go down x amount of cells).
	

	// Creating 2 Player objects.
	Player p1 = new Player("Player 1");
	Player p2 = new Player("Player 2");
	
	// firstPlayer and secondPlayer refer to their turn order.
	Player firstPlayer;
	Player secondPlayer;
	Player winner;
	
	// Introducing the Scanner class
	Scanner input = new Scanner(System.in);
	
	// CONSTRUCTORS
	/**
	 * Default Constructor
	 */
	public LadderAndSnake() {
		this.numOfPlayers = 2;
	}
	
	/**
	 * Custom Constructor 
	 * @param numOfPlayers 	number of players in the game
	 */
	public LadderAndSnake(int numOfPlayers) {
		if (numOfPlayers < 2) {
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit.");
			System.exit(0);
		}	
		if (numOfPlayers > 2) {
			System.out.println("Initialization was attempted for " + numOfPlayers + " member of players; however, this is only "
							+ "expected for an extended version the game. Value will be set to 2. \n");
		}
		this.numOfPlayers = 2;
	}
	
	/**
	 * Copy Constructor 
	 * @param ladderandsnake	ladderandsnake object to be copied
	 */
	public LadderAndSnake(LadderAndSnake ladderandsnake) {
		this.numOfPlayers = ladderandsnake.numOfPlayers;
	}
	
	
	// ACCESSORS
	/**
	 * Accessor method for the number of players
	 * @return an integer of the player count.
	 */
	public int getNumOfPlayers() {
		return this.numOfPlayers;
	}
	
	// MUTATORS
	/**
	 * Mutator method
	 * @param n an integer of the desired player count.
	 */
	public void setNumOfPlayers(int n) {
		this.numOfPlayers = n;
	}
	
	
	// METHODS
	/**
	 * Method to display the rules of the game.
	 */
	public void displayRules() {
		System.out.println(" ~~~ RULES ~~~ \n\n" +
		"- The winner is the 1st player that gets to exactly position 100. \n" +
		"- If a dice roll goes past cell 100, you will go backwards depending on the remainder. \n" + 
		"- Players cannot be on the same position. The newly landed player will overtake the former's cell, who will go to 0.\n" +
		"- The turn order will be determined with a dice roll - Largest roll starts 1st. \n" +
		"- Landing on the bottom of a ladder will allow you to move up to the top of the ladder :) \n" +
		"- Landing on the head of the snake will lead you to go down to the snake's tail :( \n" +
		"- Have fun!! \n");
		promptContinue();
	}
	
	
	/**
	 * Method allowing the user to change their player name.
	 */
	public void promptRename() {
		// Setting p1/Player 1's name.	
		System.out.println("\nPlayer 1 - Enter your desired name: (current name: " + p1.getName() + ")");
		String userName1 = input.nextLine();
		p1.setName(userName1);
		System.out.println("Name has been successfully changed to " + p1.getName());
		
		// Setting p2/Player 2's name. 
		System.out.println("Player 2 - Enter your desired name: (current name: " + p2.getName() + ")");
		String userName2 = input.nextLine();
		p2.setName(userName2);
		System.out.println("Name has been successfully changed to " + p2.getName() + "\n");
	}
	
	
	/**
	 * Method to simulate a dice roll from numbers 1-6 inclusively.
	 * @return an int of the result of the dice roll.
	 */
	public int flipDice() {
		Random dice = new Random();
		int diceResult = dice.nextInt(6)+1;
		System.out.println("Rolling the dice...");
		return diceResult;
	}
	
	
	/**
	 * Method to determine the player order by comparing their dice roll. Loop if there is a tie.
	 * @see #flipDice()
	 */
	public void decideTurnOrder() {
		System.out.println(" ~~~ DECIDING THE TURN ORDER ~~~ \n");
		int counter = 0;
		int RollP1, RollP2 = 0;
		
		do {
			RollP1 = flipDice();
			System.out.println(p1.getName() + " rolled a " + RollP1);
			RollP2 = flipDice();
			System.out.println(p2.getName() + " rolled a " + RollP2);
			counter++;
			if (RollP1 == RollP2) {
				System.out.println("A tie was made - Attempting to break the tie: \n");
			}
		} while (RollP1 == RollP2);	// Keep rolling until they players have different dice results.
		
		// Set the turn order.
		System.out.println("\nAfter " + counter + " attempts, the turn order has been decided!");
		if (RollP1 > RollP2) {		// P1 starts
			System.out.println(p1.getName() + " will start, followed by " + p2.getName() + "\n");
			firstPlayer = p1;
			secondPlayer = p2;
			
		} else {					// P2 starts
			System.out.println(p2.getName() + " will start, followed by " + p1.getName() + "\n");
			firstPlayer = p2;
			secondPlayer = p1;
		}
		promptContinue();
	}
	
	
	/**
	 * Method prompting the user to use the "Enter" key to continue the game and proceed.
	 */
	public void promptContinue() {
		System.out.println("(Press the 'ENTER' key to continue)");
		input.nextLine();
	}
	

	/**
	 * Method that checks if the player's current position is on the bottom of a ladder or at the top of a snake on the board[][].
	 * @param position	player's initial position to be checked
 	 * @return an int of the change in position (0 = stay, + means ladder, - means snake).
	 */
	public int checkForSnakeOrLadder(int position) {
		int row = 0;
		int column = 0;
		
		row = (position - 1) / 10;
		column = (position - 1) % 10;
				
		int difference = board[row][column];
		if (difference > 0) {
			System.out.print(" !! - Yay! Landed on a ladder! Go up by " + difference + " spaces");
		}
		if (difference < 0) {
			System.out.print(" !! - Oh no! Landed on a snake :( Go down by " + difference + " spaces");
		}
		
		return difference;
	}
	
	
	/**
	 * Method that checks if the current player is sharing the same position as the other player. Since the current player
	 * just rolled, they are the one that reached the cell last - the other player will then get put back to position 0.
	 * @param currentPlayer	Player in which it is their turn
	 * @param otherPlayer	Player in which it is NOT their turn
	 */
	public void checkForPlayer(Player currentPlayer, Player otherPlayer) {
		if (currentPlayer.getPosition() == otherPlayer.getPosition()) {
			otherPlayer.setPosition(0);
			System.out.println(" !! - " + currentPlayer.getName() + " has taken over " + otherPlayer.getName() + "'s position! " 
								+ otherPlayer.getName() + " has gone back to position 0.");
		}
	}
	
	
	/**
	 * Method that depicts a single, one-way turn of the current player. 
	 * @param currentPlayer	Player object of the current player
	 * @param otherPlayer	Player object of the other player
	 * @see #checkForSnakeOrLadder(int)
	 * @see #checkForPlayer(Player, Player)
	 */
	public void turn(Player currentPlayer, Player otherPlayer) {
		int currentDice = 0;
		int newPos = 0;
		int difference = 0;
		int finalPos = 0;
		
		currentDice = flipDice();						// Current player rolls a dice.
		newPos = currentPlayer.getPosition() + currentDice;				
		currentPlayer.setPosition(newPos);					// Current player's new position is updated.
		System.out.print(currentPlayer.getName() + " rolled a " + currentDice);
		
		// Player backtracks if position exceeds 100.
		if (currentPlayer.getPosition() > 100) {
			finalPos = 100 - ((currentPlayer.getPosition()) - 100);
			currentPlayer.setPosition(finalPos);
		}
		System.out.print(" - Now at position " + currentPlayer.getPosition() + "\n");
		
		
		difference = checkForSnakeOrLadder(currentPlayer.getPosition());	// Checking for a snake/ladder.
		currentPlayer.setPosition(difference + currentPlayer.getPosition());	// Update current player's position if necessary
		if (difference != 0) {
			System.out.print(" --> Currently at position " + currentPlayer.getPosition() + "\n");
		}
	
		checkForPlayer(currentPlayer, otherPlayer);				// Checking if current player's position overlaps with another.
	}
	

	/**
	 * Method to initiate the core engine of the game and start playing. Loops until a player lands on position 100.
	 * @see #turn(Player, Player)
	 */
	public void play() {
		int turns = 0;
		System.out.println("_____________________________________________________________________");
		System.out.println("\n ~~~ GAME START! ~~~ \n");
		
		while (firstPlayer.getPosition() != 100 && secondPlayer.getPosition()!= 100) {
			turn(firstPlayer, secondPlayer);	
			turn(secondPlayer, firstPlayer);	
			System.out.println("");
			turns++;
			promptContinue();
		}
		
		System.out.println(" ~~~ END ~~~\n\n" +
				"_____________________________________________________________________\n");
		if (p1.getPosition() == 100) {
			winner = p1;
		} else if (p2.getPosition() == 100) {
			winner = p2;
		}
		
		System.out.println("Total turns: " + turns);
		System.out.println(endMessage());
		System.exit(0);
	}
	
	
	/**
	 * Method of a final message indicating the winner and thanking the players.
	 * @return a String message for the players
	 * @see #play()
	 */
	public String endMessage() {
		return "WOW! Congratulations on reaching cell 100! The winner is " + winner.getName()
		+ ". \nThank you for playing, hope you enjoyed the game and had fun!! :D";
	}
	

}
