class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftindex = -1, rightindex = -1, l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(mid == 0 && nums[mid] == target) {
                leftindex = mid;
                break;
            }
            else if(mid > 0 && nums[mid] == target && nums[mid - 1] != target) {
                leftindex = mid;
                break;
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else if(nums[mid] > target || (mid > 0 && nums[mid - 1] == target)) {
                r = mid - 1;
            }
        }

        l = 0;
        r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(mid == nums.length - 1 && nums[mid] == target) {
                rightindex = mid;
                break;
            }
            else if(mid < nums.length - 1 && nums[mid] == target && nums[mid + 1] != target) {
                rightindex = mid;
                break;
            }
            else if(nums[mid] < target || (mid < nums.length - 1 && nums[mid + 1] == target)) {
                l = mid + 1;
            }
            else if(nums[mid] > target) {
                r = mid - 1;
            }
        }

        return new int[]{leftindex, rightindex};
    }
}