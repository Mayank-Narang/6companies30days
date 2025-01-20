class Solution {
    public int stoneGameVI(int[] a, int[] b) {
        
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((c,d) -> (d[0]-c[0]));

        for (int i = 0; i < n; i++)
            pq.add(new int[]{a[i]+b[i],i});

        boolean choice = true;

        int alice = 0, bob = 0;

        while (!pq.isEmpty()){
            
            int idx = pq.poll()[1];

            if (choice)
                alice += a[idx];
            else
                bob += b[idx];

            choice = !choice;

        }

        return (alice > bob) ? 1 : ((alice == bob) ? 0 : -1);

    }
}
