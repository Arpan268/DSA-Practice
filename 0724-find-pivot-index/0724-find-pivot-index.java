class Solution {
    public int pivotIndex(int[] nums) {
        int result[] = new int[nums.length];
        int pre = 0, post = 0, pivot = -1;

        for(int i = 0; i<nums.length;i++) {
            result[i] = pre;
            pre += nums[i];
        }
        for(int i = nums.length-1; i>=0; i--) {
            if(result[i] == post) pivot = i;
            post += nums[i];
        }

        return pivot;
    }
}