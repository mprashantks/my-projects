# Tic Tac Toe
Tic-tac-toe (also known as noughts and crosses or Xs and Os) is a paper-and-pencil game for two players, X and O, 
who take turns marking the spaces in a 3×3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.

## Mechanics
This game uses minmax algorithm for decision making. In Minimax the two players are called maximizer and minimizer. 
The maximizer tries to get the highest score possible while the minimizer tries to get the lowest score possible.

Every board state has a value associated with it. In a given state if the maximizer has upper hand then, 
the score of the board will tend to be some positive value. If the minimizer has the upper hand in that board state then 
it will tend to be some negative value. The values of the board are calculated by some heuristics which are unique 
for every type of game.
