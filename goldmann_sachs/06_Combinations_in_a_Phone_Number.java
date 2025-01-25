class Solution {

    List<String> ans = new ArrayList<>();
    String[] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void solve(int ind, String digits,StringBuilder sb){

        if (ind == digits.length()){
            if (sb.length() != 0)
                ans.add(sb.toString());
            return;
        }

        int num = (digits.charAt(ind)-'0')-2;

        for (int i = 0;i < letters[num].length(); i++){
            sb.append(letters[num].charAt(i));
            solve(ind+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public List<String> letterCombinations(String digits) {
        solve(0,digits,new StringBuilder());
        return ans;
    }
}
