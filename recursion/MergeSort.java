package recursion;

public class MergeSort {
	public static void mergeSort(int a[]) {
		if (a.length <= 1) {
			return;
		}
		int b[] = new int[a.length / 2];
		int c[] = new int[a.length - b.length];

		for (int i = 0; i < a.length / 2; i++) {
			b[i] = a[i];
		}
		for (int i = a.length / 2; i < a.length; i++) {
			c[i - a.length / 2] = a[i];
		}
		mergeSort(b);
		mergeSort(c);
		merge(b, c, a);

	}

	// s1-b
	// s2-c
	// d-a
	public static void merge(int[] b, int[] c, int[] a) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < b.length && j < c.length) {
			if (b[i] <= c[j]) {
				a[k] = b[i];
				i++;
				k++;
			} else {
				a[k] = c[j];
				k++;
				j++;
			}
		}
		if (i < b.length) {
			while (i < b.length) {
				a[k] = b[i];
				i++;
				k++;

			}
		}
		if (j < c.length) {
			while (j < c.length) {
				a[k] = c[j];
				k++;
				j++;
			}
		}

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 9, 8, 6, 5, 6, 3 };
		mergeSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}

	}

}
