package dyanamicprogramming;

import java.util.Scanner;

public class MinCostPathIterarive {
	public static int mincostIterative(int[][] cost) {
		int m = cost.length;
		int n = cost[0].length;

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					System.out.println("Kya hua ji? ");
					dp[i][j] = cost[i][j];
					continue;
				}
				System.out.println("hello1 " + i + " " + j);
				int ans1 = dp[i][j + 1];
				System.out.println("hello2 " + i + " " + j);
				int ans2 = dp[i + 1][j];
				System.out.println("hello3 " + i + " " + j);
				int ans3 = dp[i + 1][j + 1];
				System.out.println("hello4 " + i + " " + j);
				dp[i][j] = cost[i][j] + Math.min(Math.min(ans2, ans3), ans1);
			}
		}
		return dp[0][0];
	}
	private static int mincostpathhelper2(int[][] cost, int i, int j, int[][] dp) {
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
		if(dp[i][j] != 0)
		{
			return dp[i][j];
		}

		int ans1 = mincostpathhelper2(cost, i + 1, j,dp);
		int ans2 = mincostpathhelper2(cost, i + 1, j + 1,dp);
		int ans3 = mincostpathhelper2(cost, i, j + 1,dp);
		int ans = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		dp[i][j] = ans;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3 4
//		3 4 1 2
//		2 1 8 9
//		4 7 8 1
		// ans = 13
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();

		int[][] cost = new int[m][n];

		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				cost[i][j] = s.nextInt();
			}
		}
//		int[][] dp = new int[m + 1][n + 1];
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				dp[i][j] = Integer.MIN_VALUE;
//			}
//		}
		
		//System.out.println(mincostIterative(cost));
		System.out.println(mincostpathhelper2(cost, m, n, new int[m+1][n+1]));

	}

}
