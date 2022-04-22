package dyanamicprogramming;

import java.util.Scanner;

public class MinimumStepsTo1 {
	public static int minStepTo1Iterative(int n) {
		if (n == 0 || n == 1) {
			return 0;
		} else if (n == 2 || n == 3)
			return 1;

		int[] dp = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			dp[i] = -1;

		// Setting base cases
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			System.out.println("Current i: " + i);
			int ans1 = dp[i - 1];
			int ans2 = Integer.MAX_VALUE, ans3 = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				ans2 = dp[i / 2];
			}
			if (i % 3 == 0) {
				ans3 = dp[i / 3];
			}
			System.out.println("ans1: " + ans1 + ", ans2: " + ans2 + ", ans3: " + ans3);
			dp[i] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
			System.out.println(i + ": " + dp[i]);
		}
		return dp[n];
	}

	// rescursivecode using DP
	// time Complexity is O(n)
	// Space Complexity is O(n)
	public static int minStepto1(int n, int[] dp) {
		if (n == 1) {
			return 0;
		}
		int ans1;
		if (dp[n - 1] == -1) {
			ans1 = minStepto1(n - 1, dp);
			dp[n - 1] = ans1;
		} else {
			ans1 = dp[n - 1];
		}
		int ans2 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			if (dp[n / 2] == -1) {
				ans2 = minStepto1(n / 2, dp);
				dp[n / 2] = ans2;
			} else {
				ans2 = dp[n / 2];
			}
		}
		int ans3 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			if (dp[n / 3] == -1) {
				ans3 = minStepto1(n / 3, dp);
				dp[n / 3] = ans3;
			} else {
				ans3 = dp[n / 3];
			}
		}
		return Math.min(Math.min(ans2, ans3), ans1) + 1;
	}

	public static int minstep(int n) {

		if (n == 1) {
			return 0;
		}
		int ans1 = minstep(n - 1);
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			ans2 = minstep(n / 2);
		}
		if (n % 3 == 0) {
			ans3 = minstep(n / 3);
		}
		return Math.min(Math.min(ans2, ans3), ans1) + 1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minstep(n));
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = -1;
		}
		//System.out.println(minStepto1(n, dp));
		System.out.println(minStepTo1Iterative(n));

	}

}
