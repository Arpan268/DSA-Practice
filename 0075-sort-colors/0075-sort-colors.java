class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        for(int i = 0; i <= high; i++) {
            while(nums[i] == 2 && i != high) {
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
            while(nums[i] == 0 && i != low) {
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
            }
        }
    }
}