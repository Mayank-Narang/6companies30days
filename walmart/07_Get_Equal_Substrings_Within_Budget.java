class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n ; i++)
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        
        int l = 0, r = 0, len = 0,cost = 0;

        while (r < n){

            cost += diff[r];

            if (cost > maxCost)
                cost -= diff[l++];

            len = Math.max(len, r++ - l + 1);

        }

        return len;

    }
}
