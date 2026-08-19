class Solution {
    public int firstMissingPositive(int[] nums) {
        int contains1 = 0;
        int missingno = 0;

        for(int n: nums) {
            if(n == 1) contains1++;
        }

        if(contains1 == 0) return 1;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>nums.length || nums[i]<=0) nums[i] = 0;
        }

        for(int i = 0; i<nums.length; i++) {
            while(nums[i] > 0 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i = 0; i<nums.length; i++) {
            if(i != nums[i]-1) return i+1;
        }

        return nums.length + 1;
    }
}