//this question brought me back the memories when i started solving graphs questions

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[] dirs = {-1,0,1,0,-1};

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0;j < m; j++)
                if (grid[i][j] == 2)
                    q.add(new int[]{i,j,0});
                else if (grid[i][j] == 1)
                    fresh++;

        int max = 0;

        while (!q.isEmpty()){

            int[] rotten = q.poll();

            max = Math.max(max,rotten[2]);

            for (int i = 0; i < 4; i++){

                int row = rotten[0]+dirs[i];
                int col = rotten[1]+dirs[i+1];

                if (row >-1 && row < n && col > -1 && col < m && grid[row][col] == 1){
                    grid[row][col] = 2;
                    q.add(new int[]{row,col,rotten[2]+1});
                    fresh--;
                }

            }

        }

        return fresh == 0 ? max : -1;

    }
}
