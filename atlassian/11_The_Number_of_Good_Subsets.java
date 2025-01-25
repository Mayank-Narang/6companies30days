class Solution {
    long[][] dp = new long[1025][1025];

    long binaryExponentiation(int a, long x, int md) {
        if (x == 0) return 1;
        long half = binaryExponentiation(a, x / 2, md) % md;
        if (x % 2 == 0) {
            return (half % md * half % md) % md;
        }
        return (a % md * half % md * half % md) % md;
    }

    long getValue(List<Long> v, int index, int mask, Map<Long, Long> mp) {
        int md = 1000000007;
        if (index == v.size()) return (mask > 0) ? 1 : 0;
        if (dp[index][mask] != -1) return dp[index][mask];

        long a = getValue(v, index + 1, mask, mp) % md;
        long b = 0;
        if ((mask & v.get(index)) == 0) {
            b = ((mp.get(v.get(index)) % md) * (getValue(v, index + 1, mask | v.get(index).intValue(), mp) % md) % md) % md;
        }
        return dp[index][mask] = (a % md + b % md) % md;
    }

    void canTake(int x, int[] primes, Map<Long, Long> mp) {
        boolean check = true;
        long num = 0;
        for (int i = 0; i < 10; i++) {
            int cnt = 0;
            while (x % primes[i] == 0) {
                x /= primes[i];
                cnt++;
                if (cnt > 1) {
                    check = false;
                    break;
                }
            }
            if (cnt == 1) num |= (1L << i);
        }
        if (check) {
            mp.put(num, mp.getOrDefault(num, 0L) + 1);
        }
    }

    public int numberOfGoodSubsets(int[] nums) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        List<Long> v = new ArrayList<>();
        Map<Long, Long> mp = new HashMap<>();
        long ones = 0;

        for (int x : nums) {
            if (x == 1) ones++;
            else canTake(x, primes, mp);
        }

        for (long key : mp.keySet()) {
            v.add(key);
        }

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        int md = 1000000007;
        long ans = getValue(v, 0, 0, mp) % md;
        long power = binaryExponentiation(2, ones, md) % md;
        ans = ((ans % md) * power % md) % md;
        return (int) (ans % md);
    }
}
