class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1, max = -1, badindex = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                badindex = i;
                continue;
            }

            if (nums[i] == minK)
                min = i;

            if (nums[i] == maxK)
                max = i;

            if (Math.min(min, max) > badindex && min > -1 && max > -1) {
                count += Math.min(min, max) - badindex;
            }
        }

        return count;
    }
}