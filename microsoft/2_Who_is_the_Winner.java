class Solution {
    public int findTheWinner(int n, int k) {
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list.add(i+1);
        }

        int ind = 0;

        while (list.size() != 1){
            
            if (ind == list.size())
                ind = 0;

            int next = ind+(k-1);
            next %= list.size();
            
            list.remove(next);
            ind = next;

        }

        return list.get(0);

    }
}

//Better solution

class Solution {
    public int winnerIdx(int n, int k){
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            idx = (idx + k) % i;
        }
        return idx;
    }

    public int findTheWinner(int n, int k) {
        return winnerIdx(n, k) + 1;
    }
}
