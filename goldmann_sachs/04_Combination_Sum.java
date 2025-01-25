class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    private void solve(int n, int k, int i,List<Integer> list){

        if (n == 0 && k == 0){
            ans.add(new ArrayList<>(list));
            return ;
        }
        else if (k == 0) return ;
        else if (n == 0) return ;
        else if (n < i) return ;
        else if (i >= 10) return ;

        for (; i < 10; i++){
            
            if (i > n) break;
            list.add(i);
            solve(n-i,k-1,i+1,list);
            list.remove(list.size()-1);

        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        solve(n,k,1,new ArrayList<>());

        return ans;
    }
}
