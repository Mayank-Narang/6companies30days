class Solution {
    public void wiggleSort(int[] nums) {
        
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++){
            max = Math.max(max,nums[i]);
        }

        int[] freq = new int[max+1];

        for (int i = 0; i < n; i++){
            freq[nums[i]]++;
        }

        int j = max;

        for (int i = 1; i < n; i+=2){
            
            nums[i] = j;
            freq[j]--;

            while (freq[j] == 0)
                j--;
        }

        for (int i = 0; i < n; i+=2){

            nums[i] = j;
            freq[j]--;

            while (j > 0 && freq[j] == 0)
                j--;

        }

    }
}
