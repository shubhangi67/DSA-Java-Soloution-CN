package dyanamicprogramming;

import java.util.Scanner;

public class MinSquareRequiredSolvedByMe {
	// Solved Recurcively
	public static int minsquare(int n) {
		if (n == 0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns = minsquare(n - (i * i));
			// System.out.println("currAns " + currAns);
			if (minAns > currAns) {
				minAns = currAns;
			}
			System.out.println("Minimum answer " + minAns);
		}
		return 1 + minAns;
	}

	// Solved by using memoization or using dynamic recursive
	// Solved by me
	public static int minsquareUsingRecursiveDP(int n, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int minAns = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns = minsquareUsingRecursiveDP(n - (i * i), dp);
			System.out.println("currAns " + currAns);
			if (minAns > currAns) {
				minAns = currAns;
			}
			System.out.println("Minimum answer " + minAns);
		}
		int ans = 1 + minAns;
		dp[n] = ans;
		System.out.println("Kya answer de rahe tum " + dp[n]);
		return ans;
	}

	// recursive dyanamic programming solved by parikh sir
	// Time Complexity root n work
	// OverAll complexity is O(n root n):
	public static int minsquareRecursiveDP(int n, int[] dp) {

		if (n == 0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns;
			if (dp[n - (i * i)] == -1) {
				currAns = minsquareRecursiveDP(n - (i * i), dp);
				dp[n - (i * i)] = currAns;
			} else {
				currAns = dp[n - (i * i)];
			}

			if (minAns > currAns) {
				minAns = currAns;
			}

		}
		int myAnswer = 1 + minAns;
		return myAnswer;
	}
	// time Complexity is O(n root n)
	// Iterative solution never give you stack over flow error
	public static int minSquareIterative(int n) {
		int[] dp = new int[n + 1];
		
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			int minAns = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int currAns = dp[i - (j * j)];
				System.out.println("CurrentAnswer  " + currAns);
				if(minAns >currAns)
				{
					minAns = currAns;
					System.out.println("MinAnswer Everytime "+minAns);
				}
			}
			dp[i]=1+minAns;
			System.out.println(dp[i]);
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// System.out.println(minsquare(n));
		// System.out.println(minsquareUsingRecursiveDP(n, new int[n + 1]));
		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		//System.out.println(minsquareRecursiveDP(n, dp));
		System.out.println(minSquareIterative(n));
	}

}
