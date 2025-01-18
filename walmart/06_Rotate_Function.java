//this is something different
//feels like a legit dp question where you can see the previous computed thing being used here
//kind of like fibonacci but on red bull
//not very confident with the solution

class Solution {
    public int maxRotateFunction(int[] A) {
        
        if (A ==  null || A.length == 0)
            return 0;

        int sum = 0,f0 = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++){

            sum += A[i];
            f0 += i*A[i];

        }

        int[] dp = new int[A.length];
        dp[0] = f0;
        max = dp[0];

        for (int i = 1; i < A.length; i++){

            dp[i] = dp[i-1] + sum - A.length * A[A.length-i];
            max = Math.max(max,dp[i]);

        }

        return max;

    }
}
