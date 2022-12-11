import java.util.*;

class ClimbingStairs {

	public static int findWays(int n) {
		if(n == 1) return 1;
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 20;
		System.out.println(ClimbingStairs.findWays(n));
	}
}