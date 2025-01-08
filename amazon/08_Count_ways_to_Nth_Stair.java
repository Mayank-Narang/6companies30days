//tle for both my way of memoisation and normal recursion

class Solution {

    int[][][] dp;

    private int solve(int k, int step, int drop, int count) {

        if (step > k + 1) return 0;

        if (dp[step][count][drop] != -1) 
            return dp[step][count][drop];

        int ways = 0;

        if (step == k) ways++;

        if (drop == 1 && step > 0) 
            ways += solve(k, step - 1, 0, count);

        int nextStep = step + (1 << count);
        if (nextStep <= k + 1) 
            ways += solve(k, nextStep, 1, count + 1);

        dp[step][count][drop] = ways;
        return ways;
    }

    public int waysToReachStair(int k) {
        dp = new int[k + 2][30][2];

        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < 30; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(k, 1, 1, 0);
    }
}

//took help from gpt to improve the solution further

class Solution {

    private long[][][] dp;
    private long[] exp;

    private long find(int pos, int stat, int jump, int back, int k) {
        if (pos > k + 1)
            return 0;

        if (dp[jump][back][stat] != -1)
            return dp[jump][back][stat];

        long ans = 0;

        if (pos == k)
            ans++;

        if (stat == 1) {
            ans += find(pos - 1, 0, jump, back + 1, k);
            ans += find(pos + (int) exp[jump], 1, jump + 1, back, k);
        }

        if (stat == 0) {
            ans += find(pos + (int) exp[jump], 1, jump + 1, back, k);
        }

        return dp[jump][back][stat] = ans;
    }

    public int waysToReachStair(int k) {
        dp = new long[50][50][2];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        exp = new long[33];
        for (int i = 0; i < 33; i++) {
            exp[i] = (long) Math.pow(2, i);
        }

        return (int) find(1, 1, 0, 0, k);
    }
}
