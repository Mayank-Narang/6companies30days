//recursion gives tle
//memoisation works
//made a mistake first time leading to mle then used only 2 indices for the prev value

class Solution {

    int[][][] dp;

    private int solve(int[] p,int k,int ind,int prev){

        if (k == 0 || ind == p.length){
            return 0;
        }

        if (dp[k][ind][prev] != -1)
            return dp[k][ind][prev];

        int profit = solve(p,k,ind+1,prev);

        if (prev == 1)
            profit = Math.max(profit,p[ind] + solve(p,k-1,ind+1,0));
        else profit = Math.max(profit,-p[ind] + solve(p,k,ind+1,1));

        return dp[k][ind][prev] = profit;

    }

    public int maxProfit(int k, int[] prices) {

        dp = new int[k+1][prices.length][2];

        for (int i = 0; i <= k;i++){
            for (int j = 0; j < prices.length; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(prices,k,0,0);
    }
}
