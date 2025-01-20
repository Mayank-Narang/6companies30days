class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        
        boolean condition = false;
        int count = 0;
        int max = (int)1e5;

        while (!condition){
            condition = true;
            for (int i = 0; i < a.length; i++){

                if (mass >= a[i]){

                    mass += a[i];
                    a[i] = Integer.MAX_VALUE;
                    condition = false;
                    count++;

                    if (mass > max) return true;

                }

            }

        }

        return count == a.length;

    }
}
