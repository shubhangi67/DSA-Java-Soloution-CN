package dyanamicprogramming;

import java.util.Scanner;

public class MinCostPath {
	// Recursively solved
	public static int mincostpath(int[][] cost) {
		return mincostpathhelper(cost, cost.length, cost[0].length, 0, 0);
	}

	private static int mincostpathhelper(int[][] cost, int i, int j, int currRow, int currCol) {
		if (currRow >= i || currCol >= j) {
			return Integer.MAX_VALUE;
		}
		if (currRow == i - 1 && currCol == j - 1) {
			return cost[currRow][currCol];
		}
		int rightCostPath = mincostpathhelper(cost, i, j, currRow + 1, currCol);
		int downCostPath = mincostpathhelper(cost, i, j, currRow, currCol + 1);
		int diagonalCostPath = mincostpathhelper(cost, i, j, currRow + 1, currCol + 1);

		return cost[currRow][currCol] + Math.min(Math.min(downCostPath, rightCostPath), diagonalCostPath);
	}

	// Parikh Sir explained the solution
	private static int mincostpathhelper2(int[][] cost, int i, int j) {
//		Here i and j is current col and row
		int m = cost.length;
		int n = cost[0].length;
		// base case
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}
		// special case
		if (i == m - 1 && j == n - 1) {
			return cost[i][j];
		}

		int ans1 = mincostpathhelper2(cost, i + 1, j);
		int ans2 = mincostpathhelper2(cost, i + 1, j + 1);
		int ans3 = mincostpathhelper2(cost, i, j + 1);
		return cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
	}

// Memoization usee
	private static int mincostpathusingmemoization(int[][] cost, int i, int j, int[][] dp) {
		int m = cost.length;
		int n = cost[0].length;
		// base case
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}
		// special case
		if (i == m - 1 && j == n - 1) {
			return cost[i][j];
		}
		int ans1, ans2, ans3;
		// for right path
		if (dp[i + 1][j] == Integer.MAX_VALUE) {
			//ans1 = mincostpathusingmemoization(cost, i + 1, j, dp);
			ans1 = mincostpathhelper2(cost, i + 1, j);
			dp[i + 1][j] = ans1;
		} else {
			ans1 = dp[i + 1][j];
		}
		// for diagonal path
		if (dp[i + 1][j + 1] == Integer.MAX_VALUE) {
			//ans2 = mincostpathusingmemoization(cost, i + 1, j + 1, dp);
			ans2 = mincostpathhelper2(cost, i + 1, j + 1);
			dp[i + 1][j + 1] = ans2;
		} else {
			ans2 = dp[i + 1][j + 1];
		}
		// for downward path
		if (dp[i][j + 1] == Integer.MAX_VALUE) {
//			ans3 = mincostpathusingmemoization(cost, i, j + 1, dp);
			ans3 = mincostpathhelper2(cost, i, j + 1);
			dp[i][j + 1] = ans3;
		} else {
			ans3 = dp[i][j + 1];
		}
		return cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));

	}

	public static int mincostIterative(int[][] cost) {
		int m = cost.length;
		int n = cost[0].length;

		int[][] dp = new int[m + 1][n+ 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					dp[i][j] = cost[i][j];
					continue;
				}
				int ans1 = dp[i][j + 1];
				int ans2 = dp[i + 1][j];
				int ans3 = dp[i + 1][j + 1];
				dp[i][j] = cost[i][j] + Math.min(Math.min(ans2, ans3), ans1);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
//		3 4
//		3 4 1 2
//		2 1 8 9
//		4 7 8 1
		// ans = 18
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();

		int[][] cost = new int[m][n];

		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				cost[i][j] = s.nextInt();
			}
		}
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		// int[][] cost = { { 1, 5, 11 }, { 8, 13, 12 }, { 2, 3, 7 }, { 15, 16, 18 } };
		System.out.println(mincostpath(cost));
		System.out.println(mincostpathhelper2(cost, 0, 0));
//		System.out.println(mincostpathusingmemoization(cost, 0, 0, dp));
//		System.out.println(mincostIterative(cost));
	}

}
