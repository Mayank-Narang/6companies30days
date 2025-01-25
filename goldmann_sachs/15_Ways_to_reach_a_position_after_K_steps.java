class Solution {
    int mod = (int)1e9 + 7;
    int[][] dp;
    int abs;
    private int solve(int s,int e,int k){

        if (k == 0 && s == e)
            return 1;
        else if (k == 0)
            return 0;

        if (dp[s+abs][k] != -1)
            return dp[s+abs][k];

        int f = 0,b = 0;

        if (s+1-k <= e){
            f = (solve(s+1,e,k-1))%mod;
        }

        if (s-1+k >= e){
            b = (solve(s-1,e,k-1))%mod;
        }

        return dp[abs+s][k]= (f+b)%mod;

    }

    public int numberOfWays(int s, int e, int k) {
        
        abs = Math.abs(s-k);
        int len = s+k+abs+1;

        dp = new int[len][k+1];

        for (int i = 0; i < len; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(s,e,k);

    }
}
