class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        
        int[][] prev = new int[n][n];
        int[][] curr = new int[n][n];

        int m = edges.length;

        for (int i = 0; i < n; i++)
            Arrays.fill(prev[i],(int)1e9);

        for (int i = 0; i < m; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            prev[u][v] = edges[i][2];
            prev[v][u] = edges[i][2];

        }


        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++){
                    
                    if (j == k){
                        curr[j][k] = 0;
                    }
                    else 
                        curr[j][k] = Math.min(prev[j][k],prev[j][i] + prev[i][k]);

                }

            prev = curr;

        }

        int min = n;
        int max_node = -1;
        int count = 0;

        // for (int i = 0; i < n;i++){
        //     System.out.println(Arrays.toString(curr[i]));
        // }

        for (int i = 0; i < n; i++){
            count = 0;

            for (int j = 0; j < n; j++){

                if (curr[i][j] <= t)
                    count++;

            }

            if (min >= count){
                min = count;
                max_node = i;
            }

        }

        return max_node;

    }
}
