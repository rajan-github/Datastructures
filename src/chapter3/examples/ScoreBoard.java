package chapter3.examples;

import java.util.Arrays;
import java.util.Random;

public class ScoreBoard {

	private int numEntries;
	private GameEntry[] board;

	public ScoreBoard(int capacity) {
		board = new GameEntry[capacity];
	}

	public void add(GameEntry e) {
		int newScore = e.getScore();
		if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
			if (numEntries < board.length) {
				numEntries++;
			}
			int j = numEntries - 1;
			while (j > 0 && board[j - 1].getScore() < newScore) {
				board[j] = board[j - 1];
				j--;
			}
			board[j] = e;
		}
	}

	public GameEntry remove(int i) throws ArrayIndexOutOfBoundsException {
		if (i < 0 || i > numEntries)
			throw new ArrayIndexOutOfBoundsException();
		GameEntry temp = board[i];
		while (i < numEntries - 1) {
			board[i] = board[i + 1];
			i++;
		}
		numEntries--;
		board[numEntries] = null;
		return temp;
	}

	public void insertionSort(int[] array) {
		int temp, j;
		for (int i = 0;i < array.length; i++) {
			temp = array[i];
			j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}

	public void testSortMethod() {
		int[] array = new int[1000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10000) + (-1000);
		}
		insertionSort(array);
	}

	public static void main(String[] args) {
		ScoreBoard board = new ScoreBoard(10);
		int[] array = { 5, 4, 3, 2, 1, -1, 9, -12, 13 };
		board.insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
