class Solution {
    public String getHint(String secret, String guess) {
        
        int[] s = new int[10];
        int[] c = new int[10];

        int n = secret.length();

        int cows = 0, bulls = 0;

        for (int i = 0; i < n; i++){

            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
                continue;
            }

            s[secret.charAt(i)-'0']++;
            c[guess.charAt(i)-'0']++;

        }

        for (int i = 0; i < 10; i++)
            cows += Math.min(s[i],c[i]);

        return bulls+"A"+cows+"B";

    }
}
