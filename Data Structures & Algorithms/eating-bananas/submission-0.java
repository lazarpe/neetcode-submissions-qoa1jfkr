class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int nr : piles) {
            r = Math.max(r, nr);
        }

        int res = r;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (long) (pile + m - 1) / m;
            }

            if (totalHours > h) {
                l = m + 1;
            } else {
                res = m;
                r = m - 1;
            }
        }
        return res;
    }
}
