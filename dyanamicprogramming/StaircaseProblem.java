package dyanamicprogramming;

import java.util.Scanner;

public class StaircaseProblem {
	// Solved recurcively its time complexity is o(3 raise to the power n)
	public static long staircase(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
	}

	// Solve using memoization or using recursive dp;
	public static long staircaseUsingMemoization(int n, long[] dp) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		long ans1 = staircaseUsingMemoization(n - 1, dp);
		long ans2 = staircaseUsingMemoization(n - 2, dp);
		long ans3 = staircaseUsingMemoization(n - 3, dp);
		long ans = ans1 + ans2 + ans3;
		dp[n] = ans;
		return dp[n];
	}

	// Solve using Iteratively
	public static long staircaseIterative(int n) {
//		int[] dp = new int[n + 1];
//		dp[0] = 1;
//		dp[1] = 1;
//		dp[2] = 2;
//		for (int i = 3; i < dp.length; i++) {
//			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//		}
//		return dp[n];
//		 OR
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(staircase(n));
		System.out.println(staircaseUsingMemoization(n, new long[n + 1]));
		System.out.println(staircaseIterative(n));

	}

}
