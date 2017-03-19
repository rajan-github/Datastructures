package chapter3.creativity;

import java.util.Arrays;

public class Problem2 {

	/**
	 * given array has 1 to n-5 numbers inclusive and has 5 repetitive numbers
	 * so this method returns those repeated numbers.
	 * 
	 * @param array
	 * @return
	 */

	public int[] find5Reaped(int[] array) {
		int[] repeated = new int[5];
		int[] temp = new int[array.length];
		for (int item : array) {
			temp[item] += 1;
		}
		for (int j = 0, k = 0; j < array.length; j++) {
			if (temp[j] > 1) {
				repeated[k] = j;
				k += 1;
			}
		}
		temp = null;
		return repeated;
	}

	public static void main(String args[]) {
		Problem2 p = new Problem2();
		int array[] = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
		System.out.println("Result of the repetitive method is: ");
		System.out.println(Arrays.toString(p.find5Reaped(array)));
	}

}
