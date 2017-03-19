package chapter3.creativity;

import java.util.Arrays;

public class Problem1<E> {

	/**
	 * this method returns the first array of the item which are repeated in the
	 * array otherwise returns -1.
	 * 
	 * @param array
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E[] findRepitative(E array[]) {
		Object[] repeated = new Object[array.length];
		Arrays.sort(array);
		int j = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(array[i + 1])) {
				repeated[j] = array[i];
				j++;
			}
		}
		return (E[]) repeated;
	}

	public static void main(String args[]) {
		String array[] = { "Ram", "Ram", "Shyam","Shyam", "Kam","Kam", "Balram","Balram" };
		System.out.println("Repitive item's index is: ");
		Problem1<String> p = new Problem1<>();
		System.out.println(Arrays.toString(p.findRepitative(array)));
	}
}
