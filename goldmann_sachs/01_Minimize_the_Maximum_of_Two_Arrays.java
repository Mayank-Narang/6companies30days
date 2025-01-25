class Solution {
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        long lo = 1, hi = (long) 1e17;
        while (hi > lo + 1) {
            long mid = (lo + hi) >> 1;
            if (check(d1, d2, u1, u2, mid)) hi = mid;
            else lo = mid;
        }
        return (int) hi;
    }

    private boolean check(long d1, long d2, long u1, long u2, long x) {
        long A = x / d1;
        long A_ = x - A;
        long B = x / d2;
        long B_ = x - B;
        long AIB = x / lcm(d1, d2);
        long AuB = A + B - AIB;
        long A_I_B_ = x - AuB;

        long needA = (A_ - A_I_B_ >= u1) ? 0 : u1 - (A_ - A_I_B_);
        long needB = (B_ - A_I_B_ >= u2) ? 0 : u2 - (B_ - A_I_B_);
        
        return (A_I_B_ >= needA + needB);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
