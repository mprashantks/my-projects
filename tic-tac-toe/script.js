/**
  * Script containing the logic of tic tac toe game.
  * Here minmax algorithm is used to find the best possible move.
 **/


// Variable to store configration of board i.e., all the moves played
var origBoard;

// Stores symbol for human player
const huPlayer = 'O';

// Stores symbol for human player
const aiPlayer = 'X';

// Array consisting of all the winning combinations
const winCombos = [
	[0, 1, 2],
	[3, 4, 5],
	[6, 7, 8],
	[0, 3, 6],
	[1, 4, 7],
	[2, 5, 8],
	[0, 4, 8],
	[6, 4, 2]
]

// Query to get all objects with class cell
const cells = document.querySelectorAll('.cell');
startGame ();


// Function called at start of every game
function startGame () {

  // Intialise style display to none
	document.querySelector(".endgame").style.display = "none";

  // Intialise origBoard with the default configration i.e., array with keys from 0 to 8
  origBoard = Array.from(Array(9).keys());

  // For each cell intialise it with a empty string, remove background-color and
  // attach an event listener to listen for the clicks which works as moves
	for (var i = 0; i < cells.length; i++) {
		cells[i].innerText = '';
		cells[i].style.removeProperty('background-color');
		cells[i].addEventListener('click', turnClick, false);
	}
}


// Function to perform turn operations after a player has clicked on a cell
function turnClick(square) {

  // Condition to find if there are no previous move already made on the specific cell
  // If true than perform turn operation of player and find if player has won or there is Tie
  // If player has not won and there is no tie than ai player takes a turn
	if (typeof origBoard[square.target.id] == 'number') {
		turn(square.target.id, huPlayer)
		if (!checkWin(origBoard, huPlayer) && !checkTie()) turn(bestSpot(), aiPlayer);
	}
}


// Permorm turn operation and update board configration
function turn(squareId, player) {

  // Update layout of original board
	origBoard[squareId] = player;

  // Update html table to show move of player
  document.getElementById(squareId).innerText = player;

  // Call checkWin to find if a player has won or not
  let gameWon = checkWin(origBoard, player)

  // If player has won, than call gameOver function
	if (gameWon) gameOver(gameWon)
}


// Function to check win of a player
function checkWin(board, player) {

  // Reduce to find array containing the indexes of cell that matches the player
  // i.e., moves of player
	let plays = board.reduce((a, e, i) =>
		(e === player) ? a.concat(i) : a, []);

	let gameWon = null;

  // Find if moves of player qualify for win
  // If yes than break from loop and return gameWon
  for (let [index, win] of winCombos.entries()) {
		if (win.every(elem => plays.indexOf(elem) > -1)) {
			gameWon = {index: index, player: player};
			break;
		}
	}
	return gameWon;
}


// Function to show game result i.e., win, lose or tie
function gameOver(gameWon) {

  // Change background color of winning cells to blue if winning player is human
  // else change it to red.
	for (let index of winCombos[gameWon.index]) {
		document.getElementById(index).style.backgroundColor =
			gameWon.player == huPlayer ? "blue" : "red";
	}

  // Remove event listener to prevent any other clicks after game has ended
	for (var i = 0; i < cells.length; i++) {
		cells[i].removeEventListener('click', turnClick, false);
	}

  // Call function declareWinner to display result of game
	declareWinner(gameWon.player == huPlayer ? "You win!" : "You lose.");
}


// Function to display result of game
function declareWinner(who) {
	document.querySelector(".endgame").style.display = "block";
	document.querySelector(".endgame .text").innerText = who;
}


// Function to return all empty cells
function emptySquares() {
	return origBoard.filter(s => typeof s == 'number');
}


// Function to return index of best spot to make next move
function bestSpot() {
	return minimax(origBoard, aiPlayer).index;
}


// Function to check if tie happens
function checkTie() {

  // If all cells are filled up, than it is a tie
	if (emptySquares().length == 0) {
		for (var i = 0; i < cells.length; i++) {
			cells[i].style.backgroundColor = "green";
			cells[i].removeEventListener('click', turnClick, false);
		}
		declareWinner("Tie Game!")
		return true;
	}
	return false;
}


// Function to find best spot to make move
// Uses minmax algorithm
function minimax(newBoard, player) {

  // List of available spots
	var availSpots = emptySquares(newBoard);

	if (checkWin(newBoard, huPlayer)) {
		return {score: -10};
	} else if (checkWin(newBoard, aiPlayer)) {
		return {score: 10};
	} else if (availSpots.length === 0) {
		return {score: 0};
	}
	var moves = [];

  // For each available spot call minmax recursively to get the best possible score
  for (var i = 0; i < availSpots.length; i++) {
		var move = {};
		move.index = newBoard[availSpots[i]];
		newBoard[availSpots[i]] = player;

		if (player == aiPlayer) {
			var result = minimax(newBoard, huPlayer);
			move.score = result.score;
		} else {
			var result = minimax(newBoard, aiPlayer);
			move.score = result.score;
		}

		newBoard[availSpots[i]] = move.index;

		moves.push(move);
	}

	var bestMove;
	if(player === aiPlayer) {
		var bestScore = -10000;
		for(var i = 0; i < moves.length; i++) {
			if (moves[i].score > bestScore) {
				bestScore = moves[i].score;
				bestMove = i;
			}
		}
	} else {
		var bestScore = 10000;
		for(var i = 0; i < moves.length; i++) {
			if (moves[i].score < bestScore) {
				bestScore = moves[i].score;
				bestMove = i;
			}
		}
	}

	return moves[bestMove];
}
