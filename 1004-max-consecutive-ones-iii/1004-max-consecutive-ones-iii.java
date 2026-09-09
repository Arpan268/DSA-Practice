class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, count = 0, ans = 0;

        for(int right = 0; right<nums.length; right++) {
            if(nums[right] == 1) count++;
            int l = right-left+1;

            if(l-count <= k && l > ans) ans = l;

            else {
                if(nums[left] == 1) count--;
                left++;
            }
        }

        return ans;
    }
}