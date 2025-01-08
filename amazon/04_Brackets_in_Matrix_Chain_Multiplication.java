// by far the toughest problem that i ever encountered. this was genuinly hard, i am still a bit underconfident that i can solve this on my own or not
//also gfg must improve the comment section. people just post the solutions instead of guiding/discussing about the problems.
class Solution {
    static char matrix;
    static String ans;

    static String matrixChainOrder(int arr[]) {
        int n = arr.length;
        matrix = 'A';
        ans = "";
        int[][] dp = new int[n][n];
        int[][] path = new int[n][n];

        for (int pair = 2; pair < n; pair++) {
            for (int i = 1; i <= n - pair; i++) {
                int j = i + pair - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (temp < dp[i][j]) {
                        dp[i][j] = temp;
                        path[i][j] = k;
                    }
                }
            }
        }
        dfs(1, n - 1, path);
        return ans;
    }

    static void dfs(int i, int j, int[][] path) {
        if (i == j) {
            ans += matrix;
            matrix++;
            return;
        }
        ans += '(';
        dfs(i, path[i][j], path);
        dfs(path[i][j] + 1, j, path);
        ans += ')';
    }
}
