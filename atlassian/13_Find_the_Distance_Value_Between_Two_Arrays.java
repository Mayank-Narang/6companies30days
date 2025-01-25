class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        Arrays.sort(arr2);
        int n = arr1.length;
        int count = 0;

        for (int i = 0; i < n; i++){

            boolean check = false;
            int t = arr1[i] - d;
            int s = 0, e = arr2.length-1;

            while (s <= e){

                int mid = (e+s)/2;

                if (arr2[mid] == t){
                    count++;
                    check = true;
                    break;
                }
                else if (arr2[mid] > t){
                    e = mid-1;
                }
                else s = mid+1;

            }

            if(check) continue;

            int ans = e;

            s = 0;
            e = arr2.length-1;
            
            t = arr1[i]+d;

            while (s<=e){

                int mid = (e+s)/2;

                if (arr2[mid] == t){
                    break;
                }
                else if (arr2[mid] > t){
                    e = mid-1;
                }
                else s = mid+1;

            }

            count = count + ((e-ans) > 0 ? 1 : 0);

        }

        return arr1.length-count;

    }
}
