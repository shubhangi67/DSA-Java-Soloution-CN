package hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicatesUsingHashMap {
	
	private static ArrayList<Integer> removeDuplicate(int[] arr) {

		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				continue;
			}
			output.add(arr[i]);
			map.put(arr[i], true);
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 3, 2, 2, 3, 1, 6, 2, 5 };
		ArrayList<Integer> output = removeDuplicate(arr);
		System.out.println(output);

	}

}
