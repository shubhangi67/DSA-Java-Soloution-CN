package dyanamicprogramming;

public class LCS {
	public static int lcs1(String s, String t, int i, int j) {
		if (i == s.length() || j == t.length()) {
			return 0;
		}
		if (s.charAt(i) == t.charAt(j)) {
			return 1 + lcs1(s, t, i + 1, j + 1);
		}
		return Math.max(lcs1(s, t, i + 1, j), lcs1(s, t, i, j + 1));

	}

	public static int lcs(String s, String t, int i, int j) {
		if (i == s.length() || j == t.length()) {
			return 0;
		}
		int myAns;
		if (s.charAt(i) == t.charAt(j)) {
			int smallAns = lcs(s, t, i + 1, j + 1);
			myAns = 1 + smallAns;
		} else {
			myAns = Math.max(lcs(s, t, i + 1, j), lcs(s, t, i, j + 1));
		}
		return myAns;

	}

	public static int lcsdp(String s, String t, int i, int j, int dp[][]) {
		if (i == s.length() || j == t.length()) {
			return 0;
		}
		int myAns;
		if (s.charAt(i) == t.charAt(j)) {
			int smallAns;
			if (dp[i + 1][j + 1] == -1) {
				smallAns = lcs(s, t, i + 1, j + 1);
				dp[i + 1][j + 1] = smallAns;
			} else {
				smallAns = dp[i + 1][j + 1];
			}
			myAns = 1 + smallAns;
		} else {
			int ans1, ans2;
			if (dp[i + 1][j] == -1) {
				ans1 = lcs(s, t, i + 1, j);
				dp[i + 1][j] = ans1;
			} else {
				ans1 = dp[i + 1][j];
			}
			if (dp[i][j + 1] == -1) {
				ans2 = lcs(s, t, i, j + 1);
				dp[i][j + 1] = ans2;
			} else {
				ans2 = dp[i][j + 1];
			}
			myAns = Math.max(ans1, ans2);
		}
		return myAns;

	}

	public static int lcsIterative(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = 0;
			}
		}
		//Bottom up approach
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int ans;
				if (s.charAt(i) == t.charAt(j)) {
					ans = 1 + dp[i + 1][j + 1];
				} else {
					int ans1 = dp[i][j + 1];
					int ans2 = dp[i + 1][j];
					ans = Math.max(ans1, ans2);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str1 = "bedgmc";
		String str2 = "abdglc";
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(lcsdp(str1, str2, 0, 0, dp));
		System.out.println(lcs1(str1, str2, 0, 0));
		System.out.println(lcs(str1, str2, 0, 0));
		System.out.println(lcsIterative(str1, str2));
	}

}
