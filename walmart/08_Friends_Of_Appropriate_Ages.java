class Solution {
    public int numFriendRequests(int[] ages) {
        
        Arrays.sort(ages);
        int[] freq = new int[121];
        int count = 0;
        int n = ages.length;
        for (int i = n-1; i > 0; i--){

            int s = 0, e = i-1;

            if (freq[ages[i]] == 0)
                freq[ages[i]]++;
            if (freq[ages[i]] == freq[ages[i-1]])
                freq[ages[i]]++;
            
            int targ = (ages[i]+14)/2;

            while (s <= e){

                int mid = (e-s)/2 + s;
                if (ages[mid] <= targ){
                    s = mid + 1;
                }
                else e = mid - 1;

            }
            count += (i-e-1);

        }

        for (int i = 0; i < 121; i++){

            if (freq[i] > 0 && i > (i+14)/2){

                count += (freq[i]*(freq[i]-1)/2);

            }

        }

        return count;

    }
}
