//this solution can be improved

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Arrays.sort(words);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]==b[1] ? b[0]-a[0] : a[1]-b[1]);

        int count = 1;
        int n = words.length;
        for (int i = 1; i < n; i++){

            if (!words[i-1].equals(words[i])){
                
                if (pq.isEmpty() || pq.size() < k){
                    pq.add(new int[]{i-1,count});
                }
                else if (pq.size() == k){

                    if (pq.peek()[1] < count){
                        pq.poll();
                        pq.add(new int[]{i-1,count});
                    }
                }

                count = 1;
                
            }
            else count++;

        }

        if (pq.isEmpty() || pq.size() < k){
            pq.add(new int[]{n-1,count});
        }
        else if (pq.size() == k){
            if (pq.peek()[1] < count){
                pq.poll();
                pq.add(new int[]{n-1,count});
            }
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()){
            ans.add(words[pq.poll()[0]]);
        }

        Collections.reverse(ans);

        return ans;

    }
}
