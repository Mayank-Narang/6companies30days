class Solution {
    public static String encode(String s) {
       
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int n = s.length();
       
        char ch = s.charAt(0);
       
        for (int i = 1; i < n; i++){
           
           if (ch != s.charAt(i)){
               
               sb.append(ch+""+count);
               ch = s.charAt(i);
               count = 0;
           }
           
           count++;
           
        }
        
        sb.append(ch+""+count);
       
        return sb.toString();
       
    }
}
    
