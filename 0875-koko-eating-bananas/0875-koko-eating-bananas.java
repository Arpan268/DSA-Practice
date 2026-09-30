class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int l = 1, r = piles[piles.length - 1], ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % mid == 0) {
                    hours += piles[i] / mid;
                } else {
                    hours += piles[i] / mid + 1;
                }
            }

            if (hours <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}