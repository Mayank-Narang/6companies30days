// accepted


class Solution {
    public int wordCount(String[] s, String[] t) {
        Set<String> sSignatures = new HashSet<>();
        
        for (String word : s) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            sSignatures.add(new String(chars));
        }

        int ans = 0;

        for (String word : t) {
            for (int i = 0; i < word.length(); i++) {
                String base = word.substring(0, i) + word.substring(i + 1);
                char[] chars = base.toCharArray();
                Arrays.sort(chars);
                String signature = new String(chars);

                if (sSignatures.contains(signature)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}


//tle

class Solution {
    public int wordCount(String[] s, String[] t) {
        
        int ans = 0;

        for(int i = 0; i < t.length; i++){

            boolean[] p = new boolean[26];

            for (int j = 0; j < t[i].length(); j++){
                int ch = t[i].charAt(j)-'a';

                p[ch] = true;

            }

            for (int j = 0; j < s.length; j++){

                if (s[j].length() >= t[i].length()) continue;

                boolean[] each = new boolean[26];

                for (int k = 0; k < s[j].length(); k++){
                    int ch = s[j].charAt(k)-'a';
                    each[ch] = true;
                }

                boolean found = true;
                int count = 0;

                for (int k = 0; k < 26; k++){

                    if (each[k] && !p[k]){
                        found = false;
                        break;
                    }
                    else if (!each[k] && p[k]){
                        
                        count++;

                        if (count > 1){
                            found = false;
                            break;
                        }

                    }

                }

                if (found && count == 1){
                    ans++;
                    break;
                }
                
            }

        }

        return ans;

    }
}
