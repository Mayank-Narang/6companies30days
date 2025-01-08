//got tle first time due to heap. then i understood the approach of deque and submitted the question
//heap (gives tle)
class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        
        if (k == 1){
            
            for (int i = 0; i < n; i++)
                ans.add(arr[i]);
                
            return ans;
            
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int l = 0;
        
        for (int i = 0; i < n; i++){
            
            if (pq.size() == k){
                ans.add(pq.peek());
                pq.remove(arr[l++]);
            }
            
            pq.add(arr[i]);
                
        }
        
        ans.add(pq.peek());
        
        return ans;
        
    }
}


//deque(accepted) (pss pss plain deque also gives tle, code the condition of k == 1 and k== n to avoid it)
class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (k == 1){
            for (int i = 0; i < n; i++)
                ans.add(arr[i]);
                
            return ans;
        }
        else if (k == n){
            
            int max = -1;
            
            for (int i = 0; i < n; i++){
                max = Math.max(max,arr[i]);
            }
            
            ans.add(max);
            return ans;
            
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 1;
        
        for (int i = 0; i < n; i++){
            
            while (!dq.isEmpty() && dq.peekFirst() < i-k+1)
                dq.pollFirst();
            
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();
            
            dq.addLast(i);
            
            if (i >= k-1)
                ans.add(arr[dq.peekFirst()]);
            
        }
        
        return ans;
        
    }
}
