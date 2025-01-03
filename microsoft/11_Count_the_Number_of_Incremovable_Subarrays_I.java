class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++) {
                if (check(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;

    }

    private boolean check(int[] nums,int leave_start, int leave_end){

        for (int i = 1;i < leave_start; i++){
        
            if (nums[i] <= nums[i-1]) return false;

        }

        if (leave_start > 0 && leave_end+1 < nums.length && nums[leave_end+1] <= nums[leave_start-1] ) return false;

        for (int i = leave_end+1; i < nums.length; i++){

            if (i > leave_end+1 && nums[i] <= nums[i-1]) return false;

        }

        return true;

    }   

}
