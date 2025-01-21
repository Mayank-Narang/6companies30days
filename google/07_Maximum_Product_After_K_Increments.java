class Solution {
    public int maximumProduct(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        while(k>0){
            int ptr=0;
            nums[ptr]++;
            k--;
            while(ptr<nums.length-1 && k>0 && nums[ptr]>nums[ptr+1]){
                ptr++;
                nums[ptr]++;
                k--;
            }
        }
        long res=1;
        for(int i:nums){
            res=(res*i)%1000000007;
        }
        return (int)res;
    }
}

// less optmized my original solution
class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        int n = nums.length;
        if (n == 1) return nums[0]+k;

        int mod = (int)1e9 + 7;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            pq.add(nums[i]);

        while (k > 0){

            int a = pq.poll();
            int b = pq.poll();
            int diff = b - a + 1;
            int add = Math.min(diff,k);

            k -= add;
            pq.add(a+add);
            pq.add(b);

        }

        int prod = 1;
        if (pq.peek() == 0) return 0;

        while (!pq.isEmpty()){
            prod = (int)((1L * prod * pq.poll()) % mod);
        }

        return prod;

    }
}
