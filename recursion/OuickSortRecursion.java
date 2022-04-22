package recursion;

import java.util.Scanner;

public class OuickSortRecursion {

	public static void quickSort(int[] a, int si, int ei) {
		if (si >= ei) {
			return;
		}
		int pivotIndex = partition(a, si, ei);
		quickSort(a, si, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, ei);

	}

	public static int partition(int[] a, int si, int ei) {
		int pivotElement = a[si];
		int smallerNumberCount = 0;
		for (int i = si + 1; i <= ei; i++) {
			if (a[i] < pivotElement) {
				smallerNumberCount++;
			}
		}
		int temp = a[si+smallerNumberCount];
		a[si+smallerNumberCount] = pivotElement;
		a[si] = temp;
		int i = si;
		int j = ei;
		while (i < j) {
			if (a[i] < pivotElement) {
				i++;
			} else if (a[j] >= pivotElement) {
				j--;
			} else {
				int temp1 = a[i];
				a[i] = a[j];
				a[j] = temp1;
				i++;
				j--;
			}
		}
		return si + smallerNumberCount;
	}
	public static void quickSort(int[] a)
	{
		quickSort(a, 0, a.length-1);
	}
	public static void main(String[] args) {
		int[] input = { 5, 4, 2, 1, 6, 7, 8, 3 };
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		int[] input=new int[n];
//		for(int i=0;i<n;i++)
//		{
//			input[i]=s.nextInt();
//		}
		quickSort(input,0,input.length-1);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		// int x = 10; 
//	         
	        int x = 2;
	        int y = 0;
	        for ( ; y < 10; ++y) 
	        {
	            if (y % x == 0) 
	                continue;  
	            else if (y == 8)
	                 break;
	            else
	            System.out.print(y + " ");
	         }


	}

}
