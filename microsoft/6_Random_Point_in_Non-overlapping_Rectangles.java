//this was tough. had to watch a yt video for this

class Solution {

    private Random random;
    private int sum;
    private int[][] rects;
    private TreeMap<Integer,Integer> map;

    public Solution(int[][] rects) {
        
        random = new Random();
        map = new TreeMap<>();

        this.rects = rects;

        for (int i = 0; i < rects.length; i++){

            int[] r = rects[i];

            sum += (r[2]-r[0]+1)*(r[3]-r[1]+1);
            map.put(sum,i);
        }

    }
    
    public int[] pick() {
        
        int num = map.ceilingKey(random.nextInt(sum)+1);
        int[] xy = rects[map.get(num)];

        return new int[]{xy[0]+random.nextInt(xy[2]-xy[0]+1),xy[1]+random.nextInt(xy[3]-xy[1]+1)};

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
