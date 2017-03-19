package chapter3.examples;

import java.util.Scanner;

public class TicTacToe {

	private int board[][] = new int[3][3];
	public static final int X = 1, O = -1, EMPTY = 0;
	private int player;

	public TicTacToe() {
		super();
		clearBoard();
	}

	public void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = EMPTY;
			}
		}
		player = X;
	}

	public void putMark(int row, int column) {
		if (row > board.length-1 || column > board.length-1) {
			System.out.println("Please enter the correct position for the mark!");
			return;
		} else if (board[row][column] != EMPTY) {
			System.out.println("This position on the board is already filled with: " + board[row][column]);
			return;
		} else {
			board[row][column] = player;
			player = -player;
		}
	}

	public boolean isWin(int mark) {
		if (((board[0][0] + board[0][1] + board[0][2]) == 3 * mark)
				|| ((board[1][0] + board[1][1] + board[1][2]) == 3 * mark)
				|| ((board[2][0] + board[2][1] + board[2][2]) == 3 * mark)
				|| ((board[0][0] + board[1][0] + board[2][0]) == 3 * mark)
				|| ((board[0][1] + board[1][1] + board[2][1]) == 3 * mark)
				|| ((board[0][2] + board[1][2] + board[2][2]) == 3 * mark)
				|| ((board[0][0] + board[1][1] + board[2][2]) == 3 * mark)) {
			return true;
		} else {
			return false;
		}
	}

	public int winner() {
		if (isWin(X)) {
			return (X);
		} else if (isWin(O)) {
			return (O);
		} else {
			return 0;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				switch (board[i][j]) {
				case X:
					sb.append("X");
					break;
				case O:
					sb.append("O");
					break;
				}
				if (j < 2) {
					sb.append("|");
				}
			}
			if (i < 2) {
				sb.append("\n---------\n");
			}
		}
		return sb.toString();
	}

	public boolean gameOver() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.println("Game is Started! ");
		int temp1, temp2;
		while (true) {
			System.out.println("Enter the position for mark-");
			temp1 = Integer.parseInt(input.nextLine());
			temp2 = Integer.parseInt(input.nextLine());
			putMark(temp1, temp2);
			if (isWin(1) || isWin(-1) || gameOver()) {
				System.out.println("Game is Over-");
				int winningPlayer = winner();
				String[] outcome = { "O wins", "Tie", "X wins" }; // rely on
				System.out.println(outcome[1 + winningPlayer]);
				input.close();
				return;
			}
		}
		// input.close();
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.play();
		System.out.println(game);
	}

}
