class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];

        int[][] dirs = new int[][]{
            {-1,0},{-1,1},{0,1},{1,1},
            {1,0},{1,-1},{0,-1},{-1,-1}
        };

        int count = 0;
        int sum = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                count = 1;
                sum = img[i][j];

                for (int k = 0; k < 8; k++){
                    int r = dirs[k][0] + i;
                    int c = dirs[k][1] + j;

                    if (r > -1 && c > -1 && r < n && c < m){
                        count++;
                        sum += img[r][c];
                    }

                }

                res[i][j] =  sum/count;

            }
        }

        return res;

    }
}
