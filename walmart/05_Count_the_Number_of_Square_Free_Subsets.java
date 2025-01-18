//hard question for me as i am not so much comfortable with bit manip

class Solution {
    private int[][] memo;
    private final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private final int mod = (int) 1e9 + 7;

    private long dp(int[] nums, int i, int mask) {
        
        if (i == nums.length) return 1;
        if (memo[i][mask] != -1) return memo[i][mask];

        int tempMask = mask;
        boolean isValid = true;

        for (int j = 0; j < primes.length; j++) {
            int num = nums[i];
            int count = 0;

            while (num % primes[j] == 0) {
                num /= primes[j];
                count++;
            }

            if (count >= 2 || (count == 1 && ((mask >> j) & 1) == 1)) {
                isValid = false;
                break;
            }

            if (count == 1) {
                tempMask |= (1 << j);
            }
        }

        if (isValid) {
            memo[i][mask] = (int) ((dp(nums, i + 1, mask) + dp(nums, i + 1, tempMask)) % mod);
        } else {
            memo[i][mask] = (int) dp(nums, i + 1, mask);
        }

        return memo[i][mask];
    }

    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        memo = new int[n][1024];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1024; j++) {
                memo[i][j] = -1;
            }
        }

        return (int) ((dp(nums, 0, 0) - 1 + mod) % mod);
    }
}
