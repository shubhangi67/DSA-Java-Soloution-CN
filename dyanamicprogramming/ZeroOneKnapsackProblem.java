package dyanamicprogramming;

public class ZeroOneKnapsackProblem {
	// Recursively we will solve and see where can be the overlapping problem will
	// arise
	public static int knapSack(int W, int[] val, int[] wt, int i) {
		if (i == val.length) {
			return 0;
		}
		int ans;
		if (wt[i] <= W) {
			// Including ith item
			int ans1 = val[i] + knapSack(W - wt[i], val, wt, i + 1);
			// excluded ith item
			int ans2 = knapSack(W, val, wt, i + 1);
			ans = Math.max(ans1, ans2);
		} else {
			ans = knapSack(W, val, wt, i + 1);
		}
		return ans;
	}

	// Iterative Solution
	public static int knapSackIterative(int W, int[] val, int[] wt) {
		int n = val.length;
		int[][] dp = new int[n + 1][W + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int w = 0; w <= W; w++) {
				int ans;
				if (wt[i] <= w) {
					int ans1 = val[i] + dp[i + 1][w - wt[i]];
					int ans2 = dp[i + 1][w];
					ans = Math.max(ans1, ans2);
				} else {
					ans = dp[i + 1][w];
				}
				dp[i][w] = ans;
			}
		}
		return dp[0][W];
	}

	public static void main(String[] args) {

		int val[] = { 20, 30, 10 };
		int wt[] = { 1, 1, 1 };
		int W = 2;
		int ans = knapSack(W, val, wt,0);
		System.out.println(ans);

	}

}
