class Solution {
    private static final int MOD = 1_000_000_007;

    private long power(long a, long b, long p) {
        if (a == 0) {
            return 0;
        }
        long res = 1;
        a %= p;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % p;
            }
            b >>= 1;
            a = (a * a) % p;
        }
        return res;
    }

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }

        long largest = (1L << p) - 1; 
        long secLargest = largest - 1;
        long times = (1L << (p - 1)) - 1;

        return (int)((power(secLargest, times, MOD) * (largest % MOD)) % MOD);
    }
}
