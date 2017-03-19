package chapter3.creativity;

import java.util.Arrays;

public class AddArray {

	public int[][] add(int[][] array1, int[][] array2) {
		int sum[][] = new int[array1.length][array1[0].length];
		if (array1.length > 0 && array1[0].length > 0) {
			for (int i = 0; i < array1.length; i++) {
				for (int j = 0; j < array1[i].length; j++) {
					sum[i][j] = array1[i][j] + array2[i][j];
				}
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		AddArray adder = new AddArray();
		int[][] array1 = { { 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 6 } };
		int[][] array2 = { { 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 6 } };
		System.out.println("Adding" + Arrays.toString(array1) + "       " + Arrays.toString(array1));
		System.out.println(Arrays.toString(adder.add(array1, array2)));
	}

}
