class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                if(nums[l] <= target) {
                    r = mid - 1;
                }
                else if(nums[l] > target) {
                    if(nums[l] > nums[mid]) {
                        r = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
            }
            else if(nums[mid] < target) {
                if(nums[r] >= target) {
                    l = mid + 1;
                }
                else if(nums[r] < target) {
                    if(nums[r] < nums[mid]) {
                        l = mid + 1;
                    }
                    else {
                        r = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}