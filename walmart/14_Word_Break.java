class Solution {

    byte[] dp;

    public boolean solve(String s, int i,List<String> set){

        if (i == s.length()){
            return true;
        }

        if (dp[i] != -1)
            return dp[i] == 1;

        byte found = 0;

        for (String str: set){

            if (s.startsWith(str,i) && solve(s,i+str.length(),set)){
                found = 1;
                break;
            }

        }
        dp[i] = found;
        return found == 1;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        
        dp = new byte[s.length()+1];
        Arrays.fill(dp,(byte)-1);

        return solve(s,0,wordDict);

    }
}
