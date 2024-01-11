# snakes-and-ladder
> Snakes and Ladder simulation game coded in Java. Includes Javadoc documentation.

## Game
This program is based on the traditional board game, Snakes & Ladders. Containing 100 squares, there are various snakes and ladders scattered throughout the board. The player will roll a dice (using a random number generator) to move. The 1st player to cell 100 wins the game! However, beware of the traps - some poisonous snakes along the way might drag you down, and some convenient ladders will quicken your climb. 

The current version of the game only supports 2 players. 

![Screenshot of preview.](/capture.PNG)

## Rules
- The winner is the 1st player that gets to exactly position 100. 
- If a dice roll goes past cell 100, you will go backwards depending on the remainder. 
- Players cannot be on the same position. The newly landed player will overtake the former's cell, who will go to 0.
- The turn order will be determined with a dice roll - largest roll starts first. 
- Landing on the bottom of a ladder will allow you to move up to the top of the ladder :) 
- Landing on the head of the snake will lead you to go down to the snake's tail :( 
- Have fun!! 

## Javadoc



