package dyanamicprogramming;

public class StairCase {
	public static long staircase(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long storage[] = new long[n + 1];
		storage[0] = 1;
		storage[1] = 1;
		storage[2] = 2;
		for (int i = 3; i <= n; i++) {
			storage[i] = storage[i - 1] + storage[i - 2] + storage[i - 3];
			System.out.println(storage[i]);
		}
		return storage[n];

	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(staircase(n));
	}
}
