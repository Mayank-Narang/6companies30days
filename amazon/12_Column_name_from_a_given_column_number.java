//had to take help from yt to solve the question
class Solution {
    public String convertToTitle(int c) {
        
        StringBuilder sb = new StringBuilder();

        while (c > 0){

            c--;

            int rem = c%26;
            rem += 'A';
            
            sb.append((char)rem);

            c /= 26;

        } 

        return sb.reverse().toString();
        
    }
}
