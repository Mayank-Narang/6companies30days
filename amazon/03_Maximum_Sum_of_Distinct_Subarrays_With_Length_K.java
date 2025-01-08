//made a mistake because of data types then changed it to long and it got accepted
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        long max = 0;
        long c_m = 0;
        int l = 0;

        for (int i = 0; i < n; i++){

            if (set.contains(nums[i])){
                while (l < i && set.contains(nums[i])){
                    c_m -= nums[l];
                    set.remove(nums[l++]);
                }
            }

            set.add(nums[i]);
            c_m += nums[i];

            if (set.size() > k){
                set.remove(nums[l]);
                c_m -= nums[l++];
            }

            if (set.size() == k){
                max = Math.max(c_m,max);
            }
            
        }

        return max;

    }
}
