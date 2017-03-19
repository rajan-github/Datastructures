package chapter3.creativity;

import java.util.Random;

public class MultiplayerGame {
	public void meet(Player i, Player j) {
		if (!i.equals(j)) {
			i.meeting(j);
		}
	}

	public Player findWinner(Player[] players) {
		int maxMeeting = -1;
		Player winner = null;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getTotalMeeting() > maxMeeting) {
				winner = players[i];
				maxMeeting = players[i].getTotalMeeting();
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		MultiplayerGame game = new MultiplayerGame();
		Player[] players = new Player[1000];
		for (int i = 0; i < 1000; i++) {
			players[i] = new Player(i);
		}
		int gameRound = 50;
		Random random = new Random();
		for (int i = 0; i < gameRound; i++) {
			int player1 = random.nextInt(1000), player2 = random.nextInt(1000);
			game.meet(players[player1], players[player2]);
		}

		System.out.println("Game is over after running for 2000 rounds! Now declairing winner-");
		System.out.println(game.findWinner(players).toString());
	}
}
