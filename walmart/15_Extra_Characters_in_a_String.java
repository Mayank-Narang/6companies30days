//second solution is faster than first

// class Solution {

//     List<String> list;
//     int[] dp;
//     private int solve(String s, int idx){

//         if (idx == s.length())
//             return 0;

//         if (dp[idx] != -1){
//             return dp[idx];
//         }

//         int avoid = 1 + solve(s,idx+1);
//         int take = Integer.MAX_VALUE;

//         for (int i = idx+1; i <= s.length(); i++){

//             if (list.contains(s.substring(idx,i))){
//                 take = Math.min(take,solve(s,i));
//             }

//         }

//         return dp[idx] = Math.min(avoid,take);

//     }

//     public int minExtraChar(String s, String[] d) {
        
//         list = new ArrayList<>();

//         for (int i = 0; i < d.length; i++){
//             list.add(d[i]);
//         }

//         dp = new int[s.length()];
//         Arrays.fill(dp,-1);

//         return solve(s,0);

//     }
// }

class Solution {

    int[] t = new int[51];

    public int solve(int i, String s, Set<String> st, int n) {
        if (i >= n) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int result = 1 + solve(i + 1, s, st, n); // skipping the ith character

        for (int j = i; j < n; j++) {
            String curr = s.substring(i, j + 1);
            if (st.contains(curr)) {
                // valid substring
                result = Math.min(result, solve(j + 1, s, st, n));
            }
        }

        return t[i] = result;
    }

    public int minExtraChar(String s, String[] dict) {
        int n = s.length();
        Arrays.fill(t, -1);
        Set<String> st = new HashSet<>();

        for (int i = 0; i < dict.length; i++)
            st.add(dict[i]);

        return solve(0, s, st, n);
    }
}
