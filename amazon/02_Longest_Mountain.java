//had to watch a video for this for 2-3 minutes then figured out the remaining steps

class Solution {
    public int longestMountain(int[] arr) {
        
        int n = arr.length;
        int max = 0;

        for (int i = 1; i < n-1; i++){

            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){

                int j = i;
                int count = 1;

                while (j > 0 && arr[j] > arr[j-1]){
                    count++;
                    j--;
                }

                while (i < n-1 && arr[i] > arr[i+1]){
                    i++;
                    count++;
                }

                max = Math.max(max,count);

            }

        }

        return max;

    }
}
