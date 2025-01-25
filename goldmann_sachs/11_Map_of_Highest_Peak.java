class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int n = isWater[0].length,m = isWater.length;
        int[][] ans = new int[m][n];

        int[] dirs = {-1,0,1,0,-1};

        for (int i = 0; i < m; i++)
            Arrays.fill(ans[i],-1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){

                if(isWater[i][j] == 1){
                    q.add(new int[]{i,j});
                    ans[i][j] = 0;
                }

            }

        }

        while (!q.isEmpty()){

            int[] curr = q.poll();

            for (int i = 0; i < 4; i++){

                int row = curr[0]+dirs[i];
                int col = curr[1]+dirs[i+1];

                if (row > -1 && row < m && col > -1 && col < n && ans[row][col] == -1){
                    ans[row][col] = ans[curr[0]][curr[1]]+1;
                    q.add(new int[]{row,col});
                }

            }

        }

        return ans;

    }
}
