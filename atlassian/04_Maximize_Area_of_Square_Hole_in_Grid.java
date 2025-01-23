class Solution {

    private int solve(int[] arr){

        Arrays.sort(arr);
        int count = 2, res = 2;

        for (int i = 1; i < arr.length; i++){

            count = arr[i-1] + 1 == arr[i] ? count + 1 : 2;
            res = Math.max(res,count);

        }

        return res;

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        int max = Math.min(solve(hBars),solve(vBars));

        return max*max;


    }
}
