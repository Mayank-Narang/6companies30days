//binary search ftw

class Solution {

    private boolean bs(int[] nums,int s, int e,int t){

        while (s <= e){

            int mid = (e-s)/2 + s;

            if (nums[mid] == t)
                return true;
            else if (nums[mid] < t)
                s = mid + 1;
            else e = mid - 1;

        }

        return false;

    }

    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++){

            if (i > 0 && nums[i] == nums[i-1])
                continue;

            if (bs(nums,i+1,n-1,nums[i]+k))
                count++;

        }

        return count;

    }
}
