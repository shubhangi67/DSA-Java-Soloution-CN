package recursion;

public class SumRecursion {
	public static int sum(int n) {
		if (n == 0) {
			return 0;
		}
		int smalloutput = sum(n - 1);
		int output = n + smalloutput;
		return output;
	}

	public static void print1ton(int n) {
		if (n == 0) {
			return;
		}
		print1ton(n - 1);
		System.out.println(n);
	}

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int fib_n_1 = fib(n - 1);
		int fib_n_2 = fib(n - 2);
		int output = fib_n_1 + fib_n_2;
		return output;
	}

	public static boolean isSorted(int a[]) {
		if (a.length == 1) {
			return true;
		}
		if (a[0] > a[1]) {
			return false;
		}
		int smallArray[] = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			smallArray[i - 1] = a[i];
		}
		boolean isSmallArraySorted = isSorted(smallArray);
		return isSmallArraySorted;
	}

	public static int lastIndex(int a[], int x) {
		if (a.length == 0) {
			return -1;
		}
		int smallArray[] = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			smallArray[i - 1] = a[i];
		}
		int k = lastIndex(smallArray, x);
		if (k != -1) {
			return k + 1;
		} else {
			if (a[0] == x) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public static int lastIndex(int a[], int x, int startIndex) {
		if (startIndex == a.length) {
			return -1;
		}
		int k = lastIndex(a, x, startIndex + 1);
		if (k != -1) {
			return k;
		} else {
			if (a[startIndex] == x) {
				return startIndex;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		// System.out.println(sum(5));
		// print1ton(10);
		System.out.println(fib(5));
	}
}
