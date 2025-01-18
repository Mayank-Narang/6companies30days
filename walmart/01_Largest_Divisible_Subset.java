//gives tle due to recursion and memo
class Solution {

    List<Integer> ans = new ArrayList<>();

    private void solve(int[] nums,int idx, List<Integer> curr){

        if (idx == nums.length){


            if (ans.size() < curr.size())
                ans = new ArrayList<>(curr);

            return;

        }

        if (curr.size() == 0 || nums[idx] % curr.get(curr.size()-1) == 0){
            curr.add(nums[idx]);
            solve(nums,idx+1,curr);
            curr.remove(curr.size()-1);
        }
        
        solve(nums,idx+1,curr);

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        solve(nums,0,new ArrayList<>());
        return ans;

    }
}


//iterative dp passes the test case (not confident with this so it took me time to crack)

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIndex = 0;
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (t[i] > maxL) {
                        maxL = t[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }

        return result;
    }
}
