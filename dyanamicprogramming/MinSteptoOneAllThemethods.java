package dyanamicprogramming;

import java.util.Scanner;

public class MinSteptoOneAllThemethods {
	// Using Recursion
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

	// Using Memoization or using RecursiveDP
	public static int minstepUsingRecursiveDP(int n, int[] dp) {
		if (n == 1) {
			return 0;
		}
		if(dp[n] != 0)
		{
			return dp[n];
		}
		int ans1 = minstepUsingRecursiveDP(n - 1, dp);
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			ans2 = minstepUsingRecursiveDP(n / 2, dp);
		}
		if (n % 3 == 0) {
			ans3 = minstepUsingRecursiveDP(n / 3, dp);
		}
		int ans = Math.min(Math.min(ans2, ans3), ans1) + 1;
		dp[n] = ans;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minstep(n));
		System.out.println(minstepUsingRecursiveDP(n, new int[n+1]));

	}

}
