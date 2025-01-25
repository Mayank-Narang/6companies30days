class Solution {

    class Pair{

        String value;
        int ind;

        Pair(String value,int ind){

            this.value = value;
            this.ind = ind;

        }

    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
        
        int n = q.length;
        int m = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){

            int k = q[i][0];
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.value.compareTo(a.value) == 0 ? b.ind-a.ind : b.value.compareTo(a.value));

            for (int j = 0; j < m; j++){

                int s = nums[j].length() - q[i][1];
                String value = nums[j].substring(s);
                pq.add(new Pair(value,j));

                if (pq.size() > k)                
                    pq.poll();       

            }

            ans[i] = pq.poll().ind;

        }

        return ans;

    }
}
