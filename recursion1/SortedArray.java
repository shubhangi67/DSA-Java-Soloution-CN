package recursion1;

public class SortedArray {
	public static boolean sorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}
		if (arr[0] > arr[1]) {
			return false;
		}
		int[] smallArray = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			smallArray[i - 1] = arr[i];
		}
		boolean isSmallArray = sorted(smallArray);
		return isSmallArray;
	}

	public static boolean isSorted(int[] arr, int startIndex) {
		if (startIndex == arr.length - 1) {
			return true;
		}
		if (arr[startIndex] > arr[startIndex + 1]) {
			return false;
		}
		return isSorted(arr, startIndex + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 5, 6, 7, 8, 9 };
		 System.out.println(sorted(arr));
		System.out.println(isSorted(arr, 0));
	}

}
