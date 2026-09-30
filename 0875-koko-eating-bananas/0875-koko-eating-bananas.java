class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int l = 1, r = piles[piles.length - 1];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(mid == 1 && hours(piles, mid) <= h) {
                return 1;
            }
            else if(mid == 1 && hours(piles, mid) > h) {
                mid++;
            }
            
            if(hours(piles, mid - 1) > h && hours(piles, mid) <= h) {
                return mid;
            }

            if (hours(piles, mid) <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return 1;
    }

    private int hours(int piles[], int mid) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % mid == 0) {
                hours += piles[i] / mid;
            } else {
                hours += piles[i] / mid + 1;
            }
        }
        return hours;
    }
}