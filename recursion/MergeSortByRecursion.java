package recursion;

public class MergeSortByRecursion {
	public static void mergeSort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		int[] b = new int[a.length / 2];
		int[] c = new int[a.length - b.length];
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

	public static void merge(int[] b, int[] c, int[] a) {
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<b.length && j<c.length)
		{
			if(b[i]<c[j])
			{
				a[k]=b[i];
				k++;
				i++;
			}
			else
			{
				a[k]=c[j];
				k++;
				j++;
			}
		}
		while(i<b.length)
		{
			a[k]=b[i];
			k++;
			i++;
		}
		while(j<c.length)
		{
			a[k]=c[j];
			k++;
			j++;
		}
	}

	public static void main(String[] args) {
		int[] a= {2,3,1,4,5,9,4,6,8};
		mergeSort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}

	}

}
