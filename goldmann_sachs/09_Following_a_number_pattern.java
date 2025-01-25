class Solution{
    static String printMinNumberForPattern(String S){
        
        int n = S.length();
        StringBuilder result = new StringBuilder();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i <= n; i++) {
            stack.push(i + 1);
            
            if (i == n || S.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
        
    }
}
