class Solution {

    int[][][][] dp;

    private int solve (int x,int y,int z,int prev){

        if (x == 0 && y == 0 && z == 0)
            return 0;

        if (dp[x][y][z][prev+1] != -1)
            return dp[x][y][z][prev+1];

        int len = 0;

        if (prev == -1){

            if (x != 0)
                len = 2 + solve(x-1,y,z,0);

            if (y != 0)
                len = Math.max(len,2 + solve(x,y-1,z,1));

            if (z != 0)
                len = Math.max(len,2 + solve(x,y,z-1,2));

        }
        else{

            if (prev == 0 && y != 0)
                len = Math.max(len,2+solve(x,y-1,z,1));
            
            if (prev == 1){

                if (x != 0)
                    len = Math.max(len,2+solve(x-1,y,z,0));
                if (z != 0)
                    len = Math.max(len,2+solve(x,y,z-1,2));

            }

            if (prev == 2){

                if (x != 0)
                    len = Math.max(len,2+solve(x-1,y,z,0));
                if (z != 0)
                    len = Math.max(len,2+solve(x,y,z-1,2));

            }
        }

        return dp[x][y][z][prev+1] = len;

    }

    public int longestString(int x, int y, int z) {

        dp = new int[x+1][y+1][z+1][4];

        for (int i = 0; i <= x; i++){
            for (int j = 0; j <= y; j++){
                for (int k = 0; k <= z; k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }

        return solve(x,y,z,-1);
    }
}
