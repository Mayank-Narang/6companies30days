class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[2001];
        int mod = (int) Math.pow(10, 9) + 7;
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int k = i + delay; k < i + forget && k <= n; k++) {
                dp[k] = (dp[k] + dp[i]) % mod;
            }
        }

        int i = 0;
        long ans = 0;

        while (forget-- > 0) {
            ans = (ans + dp[n - i]) % mod;
            i++;
        }

        return (int) ans;
    }
}
