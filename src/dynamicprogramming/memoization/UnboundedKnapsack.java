import java.util.Arrays;

class UnboundedKnapsack {

    public static int solve(int wt[], int val[], int C, int n, int dp[][]) {
        if(n == 0 || C == 0) {
            dp[n][C] = 0;
            return 0;
        }
        
        if(wt[n - 1] > C) {
            dp[n][C] = solve(wt, val, C, n - 1, dp);
            return dp[n][C];
        }
        
        dp[n][C] = Math.max(val[n - 1] + solve(wt, val, C - wt[n - 1], n, dp),
        solve(wt, val, C, n - 1, dp));
        return dp[n][C];
    }

    public static int maxProfit(int wt[], int val[], int C) {
        int dp[][] = new int[wt.length + 1][C + 1];
        for(int arr[] : dp) {
            Arrays.fill(arr, - 1);
        }
        return UnboundedKnapsack.solve(wt, val, C, wt.length, dp);
    }
    public static void main(String[] args) {
        int wt[] = {1, 2, 3, 4, 8};
        int val[] = {2, 3, 3, 2, 10};
        int C = 7;
        int profit = UnboundedKnapsack.maxProfit(wt, val, C);
        System.out.println(profit);
    }
}