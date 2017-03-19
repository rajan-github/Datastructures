package chapter3.creativity;

import java.util.Arrays;
import java.util.Random;

public class Shuffle<E> {
	public E[] shuffle(E[] array) {
		Random random = new Random();
		int temp;
		E x;
		for (int i = 0; i < array.length; i++) {
			temp = random.nextInt(array.length);
			x = array[0];
			array[0] = array[temp];
			array[temp] = x;
		}
		return array;
	}

	public static void main(String args[]) {
		String array[] = { "kappa", "jappa", "happa", "sappa", "tappa" };
		Shuffle<String> shfl = new Shuffle<>();
		for (int i = 0; i < 20; i++) {
			shfl.shuffle(array);
			System.out.println(Arrays.toString(array));
		}
	}
}
