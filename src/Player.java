// -----------------------------------------------------
// Snakes & Ladder
// COMP-249: Object Oriented Programming II
// Written by: Safira Sari
// Date: Friday, February 3rd, 2023
// -----------------------------------------------------

/**
 * The Player class implements attributes and methods to create player objects.
 * 
 * @author Safira Sari
 * @version 1.0
 */

public class Player {

	private String name;
	private int position;
	
	// CONSTRUCTORS
	/**
	 * Default Constructor method, takes no arguments.
	 */
	public Player() {
		name = "";
		position = 0;
	}
	
	/**
	 * Custom Constructor method
	 * @param name	the player's name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Copy Constructor
	 * @param player	copy a player object
	 */
	public Player(Player player) {
		this.name = player.name;
		this.position = player.position;
	}
	
	
	// MUTATORS
	/**
	 * Mutator method
	 * @param n	a String value of the desired player name.
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/**
	 * Mutator method
	 * @param p	an integer value of the player's current position.
	 */
	public void setPosition(int p) {
		this.position = p;
	}
	
	// ACCESSORS
	/**
	 * Accessor method for the player's name
	 * @return a String of the player's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Accessor method for the player's position
	 * @return an integer of the player's position
	 */
	public int getPosition() {
		return this.position;
	}
	
}
