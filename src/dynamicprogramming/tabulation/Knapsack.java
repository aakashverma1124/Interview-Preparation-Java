import java.util.Arrays;

class Knapsack {

    public static int maxProfit(int wt[], int val[], int C) {
        int n = wt.length;
        int dp[][] = new int[n + 1][C + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][C];
    }
    public static void main(String[] args) {
        int wt[] = {1, 2, 3, 4, 8};
        int val[] = {2, 3, 3, 2, 10};
        int C = 7;
        int profit = Knapsack.maxProfit(wt, val, C);
        System.out.println(profit);
    }
}