class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(target == nums[mid]) {
                index = mid;
                break;
            }
            if(target > nums[mid]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return index;
    }
}