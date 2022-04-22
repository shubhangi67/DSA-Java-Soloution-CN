package TimeComplexity;

import java.util.Arrays;

public class PairSum {
	public static int pairSum(int[] arr, int N)

	{
		int count = 0;
		//Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			//for (int j = arr.length - 1; j >= 0; j--) {
			for(int j=i+1;j<arr.length;j++) {
				if (arr[i] + arr[j] == N) {
					System.out.println(i + " " + j);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 2 };
		System.out.println(pairSum(arr, 4));

	}

}
