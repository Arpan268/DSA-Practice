class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while(l < r) {
            int mid = l + (r - l) / 2;

            if(mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else if(nums[mid] < nums[r]) {
                r = mid - 1;
            }
        }

        return nums[l];
    }
}