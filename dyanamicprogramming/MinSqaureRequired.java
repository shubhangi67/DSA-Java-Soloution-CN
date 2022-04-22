package dyanamicprogramming;

import java.util.Scanner;

public class MinSqaureRequired {
	public static int minSquares(int n) {
		if (n == 0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns = minSquares(n - (i * i));
			if (minAns > currAns) {
				minAns = currAns;
			}
		}
		return 1 + minAns;
	}

	public static int minSquaresDyanamic(int n, int[] dp) {
		if (n == 0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns;
			if (dp[n - (i * i)] == -1) {
				currAns = minSquares(n - (i * i));
				dp[n - (i * i)] = currAns;
			} else {
				currAns = dp[n - (i * i)];
			}
			if (minAns > currAns) {
				minAns = currAns;
			}
		}
		return 1 + minAns;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minSquares(n));
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(minSquaresDyanamic(n, dp));
	}

}
