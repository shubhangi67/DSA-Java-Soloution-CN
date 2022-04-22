package dyanamicprogramming;

import java.util.Scanner;

public class PathWithmaximumGold {
	public static void main(String[] args) {
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
		for (int j = dp[0].length - 1; j >= 0; j--) {
			for (int i = dp.length; i >= 0; i--) {
				if (j == cost[0].length - 1) {
					dp[i][j] = cost[i][j];
				} else if (i == 0) {
					dp[i][j] = cost[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == cost.length - 1) {
					dp[i][j] = cost[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = cost[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]);
				}

			}
		}
		int max = dp[0][0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
		}
		System.out.println(max);

	}

}
