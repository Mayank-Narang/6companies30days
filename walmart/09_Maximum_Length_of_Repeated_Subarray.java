//forgot how subarrays worked so had to watch a tutorial

class Solution {
    private int[][] dp;

    private int solve(int[] n1, int[] n2, int i1, int i2) {
        if (i1 == n1.length || i2 == n2.length)
            return 0;

        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        int found = 0;
        if (n1[i1] == n2[i2]) {
            found = 1 + solve(n1, n2, i1 + 1, i2 + 1);
        }

        return dp[i1][i2] = found;
    }

    public int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLength = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                maxLength = Math.max(maxLength, solve(nums1, nums2, i, j));
            }
        }

        return maxLength;
    }
}
