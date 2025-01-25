class Solution {
    private int m, n, total;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
    }

    public int[] flip() {
        int r = (int) (Math.random() * total);
        total--;

        int pos = map.getOrDefault(r, r);

        map.put(r, map.getOrDefault(total, total));

        return new int[]{pos / n, pos % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
