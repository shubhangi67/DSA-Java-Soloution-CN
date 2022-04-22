package recursion1;

public class MergeSort {
	public static void merge(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		int[] a = new int[arr.length / 2];
		int[] b = new int[arr.length - a.length];

		for (int i = 0; i < arr.length / 2; i++) {
			a[i] = arr[i];
		}
		for (int i = arr.length / 2; i < arr.length; i++) {
			b[i - arr.length / 2] = arr[i];
		}
		merge(a);
		merge(b);
		mergeSort(a, b, arr);
	}

	public static void mergeSort(int[] a, int[] b, int[] arr) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				arr[k] = a[i];
				k++;
				i++;
			} else {
				arr[k] = b[j];
				k++;
				j++;
			}
		}
		while (i < a.length) {
			arr[k] = a[i];
			k++;
			i++;
		}
		while (j < b.length) {
			arr[k] = b[j];
			k++;
			j++;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 2, 3, 6, 4, 7, 5, 8, 9 };
		merge(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
