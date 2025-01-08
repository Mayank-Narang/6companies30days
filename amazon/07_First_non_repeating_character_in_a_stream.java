//first came to my mind approach

class Solution {
    public int firstUniqChar(String s) {
        
        int[] freq = new int[26];

        Arrays.fill(freq,-1);

        int n = s.length();
        int val = -1;

        for (int i = 0; i < n; i++){

            val = s.charAt(i)-'a';

            if (freq[val] > -1)
                freq[val] = -2;
            else if (freq[val] == -1)
                freq[val] = i;

        }

        int min = n;

        for (int i = 0; i < 26; i++){

            if (freq[i] > -1){
                min = Math.min(freq[i],min);
            }

        }

        return min == n ? -1 : min;

    }
}

// optimised it using inbuilt functions

class Solution {
    public int firstUniqChar(String s) {
        
        int min = s.length();

        for (char c = 'a' ; c <= 'z'; c++){
            int ind = s.indexOf(c);

            if (ind != -1 && ind == s.lastIndexOf(c))
                min = Math.min(min,ind);

        }

        return min == s.length() ? -1 : min;

    }
}
