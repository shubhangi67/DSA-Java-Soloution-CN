package dyanamicprogramming;

public class Fibbonacci {
	// TimeComplexity is 2 to power n
	public static int fibb(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibb(n - 1) + fibb(n - 2);
	}

	// TimeComplexity is O(n)
	// Dyanmic programming used
	// this is memoization == recursion + some storage used
	public static int fibbnacciusingDP(int n, int dp[]) {
		if (n == 0 || n == 1) {
			return n;
		}
		int ans1, ans2;
		if (dp[n - 1] == -1) {
			ans1 = fibbnacciusingDP(n - 1, dp);
			dp[n - 1] = ans1;
		} else {
			ans1 = dp[n - 1];
		}
		if (dp[n - 2] == -1) {
			ans2 = fibbnacciusingDP(n - 2, dp);
			dp[n - 2] = ans2;
		} else {
			ans2 = dp[n - 2];
		}
		return ans1 + ans2;
	}
	// Iterartive solution using DP
	public static int fibbonaciItertive(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 6;
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println("Simple Fibbonaci with time complexity O(2 to the power n)\n "+fibb(n));
		System.out.println("Fibbonaci with memoization with time complexity o(n)\n "+fibbnacciusingDP(n, dp));
		System.out.println("Iterative fibonacci\n "+fibbonaciItertive(n));

	}

}
