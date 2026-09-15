class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0, min = -1, max = -1, badindex = -1;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] > maxK || nums[right] < minK) {
                badindex = right;
                left = right + 1;
                continue;
            }

            if (nums[right] == minK)
                min = right;

            if (nums[right] == maxK)
                max = right;

            if (Math.min(min, max) >= badindex && min > -1 && max > -1) {
                count += Math.min(min, max) - badindex;
            }
        }

        return count;
    }
}