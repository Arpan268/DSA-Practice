class Solution {
    public int[] runningSum(int[] nums) {
        int result[] = new int[nums.length];
        Arrays.fill(result, 0);
        int pre = 0;

        for(int i = 0; i<nums.length; i++) {
            pre += nums[i];
            result[i] = pre;
        }

        return result;
    }
}