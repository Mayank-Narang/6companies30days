class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int med = nums[n/2];

        for (int i = 0; i < n/2; i++)
            ans += med-nums[i];
        for (int i = n/2; i < n; i++)
            ans += nums[i]-med;

        return ans;

    }
}
