class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int odd = 0, prev = 0, ans = 0;
        int n = nums.length;

        for (int l = 0, r = 0; r < n; r++){

            if (nums[r] %2 == 1){
                prev = 0;
                odd++;
            }

            while (odd == k){

                prev++;
                if (l < n && nums[l]%2 == 1)
                    odd--;

                l++;

            }

            ans += prev;

        }

        return ans;

    }
}
