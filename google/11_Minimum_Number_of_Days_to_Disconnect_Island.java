class Solution {

    int[] dirs = {-1,0,1,0,-1};

    private void dfs(boolean[][] vis,int i, int j, int[][] grid){

        if (vis[i][j] || grid[i][j] == 0)
            return;

        vis[i][j] = true;

        for (int k = 0; k < 4; k++){
            int row = i+dirs[k];
            int col = j+dirs[k+1];

            if (row > -1 && col > -1 && row < grid.length && col < grid[0].length){
                dfs(vis,row,col,grid);
            }

        }

    }

    private int find(int n, int m, int[][] grid){

        int is = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                if (grid[i][j] == 1 && !vis[i][j]){
                    is++;
                    dfs(vis,i,j,grid);
                }

                if (is == 2) return is;

            }
        }

        return is;

    }

    public int minDays(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int islands = find(n,m,grid);

        if (islands == 0 || islands > 1) return 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){

                    grid[i][j] = 0;
                    int val = find(n,m,grid);
                    if (val > 1 || val == 0)
                        return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;

    }
}
