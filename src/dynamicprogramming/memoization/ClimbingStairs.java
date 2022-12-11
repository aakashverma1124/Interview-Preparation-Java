import java.util.*;

class ClimbingStairs {

	public static int findWays(int n, int dp[]) {
		if(n == 0) {
			dp[n] = 1;
			return dp[n];
		}
		if(n < 0) {
			return 0;		
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		int right = ClimbingStairs.findWays(n - 1, dp);
		int left = ClimbingStairs.findWays(n - 2, dp);
		
		dp[n] = left + right;
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10000;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		long start = System.currentTimeMillis();
		System.out.println(ClimbingStairs.findWays(n, dp));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}