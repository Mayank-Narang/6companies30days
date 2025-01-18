//can also make the modification to only include k elements instead of taking all to reduce the complexity

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->nums[b]-nums[a]);

        for(int i = 0;i < nums.length; i++){
            pq.add(i);
            //can modify here to reduce time ms
        }

        for (int i = 0; i < k; i++){
            ans[i] = pq.poll();
        }

        Arrays.sort(ans);

        for (int i = 0; i < k; i++){
            ans[i] = nums[ans[i]];
        }

        return ans;

    }
}
