class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            int count = 0;
            for (int j = i; j < n; j++) {
                temp.add(nums[j]);
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans.size();
        
    }
}
