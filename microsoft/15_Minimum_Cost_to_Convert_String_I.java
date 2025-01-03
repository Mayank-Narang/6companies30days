class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        //List<List<int[]>> adj = new ArrayList<>();
        long ans = 0;
        int n = original.length;
        long[][] prev = new long[26][26];

        for (int i = 0; i < 26; i++){
            // adj.add(new ArrayList<>());
            Arrays.fill(prev[i],Integer.MAX_VALUE);
            prev[i][i] = 0;
        }

        // for (int i = 0; i < n; i++)
        //     adj.get(original[i]-'a').add(new int[]{changed[i]-'a',cost[i]});

        for (int i = 0; i < n; i++){
            prev[original[i]-'a'][changed[i]-'a'] = Math.min(prev[original[i]-'a'][changed[i]-'a'],cost[i]); 
        }

        for (int i = 0; i < 26; i++){
            for (int j = 0; j < 26; j++)
                for (int k = 0; k< 26; k++)
                    prev[j][k] = Math.min(prev[j][k],prev[j][i]+prev[i][k]);
            
        }

        // for (int i = 0; i < 26; i++){
        //     System.out.println(Arrays.toString(curr[i]));
        // }

        n = source.length();
        long val = 0;

        for (int i = 0; i < n; i++){
            
            if (source.charAt(i) == target.charAt(i)) continue;

            val = prev[source.charAt(i)-'a'][target.charAt(i)-'a'];

            if (val == Integer.MAX_VALUE)
                return -1;

            ans += val;

        }

        return ans;

    }
}
