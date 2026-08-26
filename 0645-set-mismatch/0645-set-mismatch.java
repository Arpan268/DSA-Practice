class Solution {
    public int[] findErrorNums(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            while(nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i = 0; i<nums.length; i++) {
            if(i+1 != nums[i]) return new int[] {nums[i], i+1};
        }

        return new int[0];
    }
}