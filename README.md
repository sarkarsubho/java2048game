# java2048game

### overview
 - This is a simple implementation of the popular 2048 game in Java, designed to run in a terminal or console environment no GUI is used here.

 ### How to play
  
  - Compile the Java source code provided in the `Runner.java` file.

```
javac Runner.java
```

- Run the game using the compiled class.

```
java Runner
```
- The game has a 4*4 matrix and initially, 2 tiles are provided with random values (either 2 or 4).
- The game board will be displayed, and you can use the W/S/A/D keys for movement (Up, Down, Left, Right). The objective is to reach the 2048 tile.

- After each move, a new tile (either 2 or 4) will appear on the board. Tiles with the same value will merge when they collide by moving in the same direction. the value of the tiles is added as a score.

- Your score will be displayed on the screen, and the game will continue until you reach the 2048 tile (Win) or there are no more valid moves (Game Over).

### Winning the Game
- To win the game, reach the 2048 tile. Upon reaching this milestone, you'll be greeted with a "You Win" message and your final score.
- win
- ![win](https://i.imgur.com/rwLDio7.png)

### Game Over
- The game concludes when there are no more valid moves left, and the board is filled with tiles. You'll be notified of a "Game Over" along with your final score.
- game over
 - ![game Over](https://i.imgur.com/UIu6OrS.png)

### Developer Notes

- The game logic is implemented in Java and can be found in the Runner.java file.

- The code provides a simple text-based interface for gameplay.
- While the code includes functionality for movement with the W/S/A/D keys for movement (Up, Down, Left, Right) for arrow key input, it is currently commented out.
- You can uncomment and adapt it and implement the functionality.
- You are welcome to expand and enhance this code to add additional features or customize the game further.
- Feel free to modify and enhance this code as required to match your preferences or project specifications. Enjoy playing 2048!
- Happy learning :).
