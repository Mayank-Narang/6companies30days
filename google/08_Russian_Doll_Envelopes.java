class Solution {

    // int[][][] dp;

    // private int solve(int[][] en,int ind,int[] prev){

    //     if (ind >= en.length){
    //         return 0;
    //     }

    //     if (dp[ind][prev[0]][prev[1]] != -1)
    //         return dp[ind][prev[0]][prev[1]];

    //     int take = 0, not_take = 0;

    //     if (en[ind][0] > prev[0] && en[ind][1] > prev[1])
    //         take =  1 + solve(en,ind+1,en[ind]);

    //     not_take = solve(en,ind+1,prev);

    //     return dp[ind][prev[0]][prev[1]] = Math.max(not_take,take);

    // }

    public int maxEnvelopes(int[][] en) {

        // int max_width = en[en.length-1][0];
        // int max_height = 0;

        // for (int i = 0; i < en.length; i++)
        //     max_height = Math.max(max_height,en[i][1]);

        // dp = new int[en.length][max_width+1][max_height+1];

        // for (int i = 0; i < en.length; i++)
        //     for (int j = 0; j <= max_width; j++)
        //         Arrays.fill(dp[i][j],-1);

        // return solve(en,0,new int[]{0,0});

        Arrays.sort(en,(a,b) -> a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]);

        int[] heights = new int[en.length];

        for (int i = 0; i < en.length; i++){
            heights[i] = en[i][1];
        }

        return length(heights);

    }

    private int length(int[] heights){

        int[] inc = new int[heights.length];
        int last = 0;

        for (int h : heights){

            int pos = bs(h,inc,last);

            if (pos < last){
                inc[pos] = h;
            }
            else inc[last++] = h;

        }

        return last;

    }

    private int bs(int h, int[] inc,int last){

        int s = 0 ,e = last -1;

        while (s <= e){

            int mid = (e-s)/2 + s;

            if (inc[mid] >= h){
                e = mid - 1;
            }
            else s = mid + 1;

        }

        return s;

    }

}
