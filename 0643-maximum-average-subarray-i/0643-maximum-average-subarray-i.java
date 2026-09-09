class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxavg = Double.NEGATIVE_INFINITY;

        int left = 0;
        for(int right = 0; right<nums.length; right++) {
            sum += nums[right];

            if(right-left+1 == k) {
                maxavg = Math.max(maxavg, sum/k);
                sum -= nums[left];
                left++;
            }
        }

        return maxavg;
    }
}