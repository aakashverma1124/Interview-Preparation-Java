import java.util.*;

class LongestCommonSubsequence {

	public static int solve(String a, String b, int m, int n, int dp[][]) {
		if(m == 0 || n == 0) return 0;

		if(dp[m][n] != -1) return dp[m][n];

		if(a.charAt(m - 1) == b.charAt(n - 1)) {
			dp[m][n] = 1 + LongestCommonSubsequence.solve(a, b, m - 1, n - 1, dp);
			return dp[m][n];
		}

		int left = LongestCommonSubsequence.solve(a, b, m - 1, n, dp); 
		int right = LongestCommonSubsequence.solve(a, b, m, n - 1, dp);
		
		dp[m][n] = Math.max(left, right);
		return dp[m][n];
	}

	public static int longestCommonSubsequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dp[][] = new int[m + 1][n + 1];
		for(int arr[] : dp) {
			Arrays.fill(arr, -1);
		}
		return solve(a, b, m, n, dp);
	}

	public static void main(String[] args) {
		String a = "abcd";
		String b = "bcad";
		int lcs = LongestCommonSubsequence.longestCommonSubsequence(a, b);
		System.out.println(lcs);
	}
}