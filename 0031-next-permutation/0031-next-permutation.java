class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            int r = nums.length - 1;

            for (int l = 0; l < r; l++) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
        }

        else {
            int r = nums.length - 1;

            for (int l = pivot + 1; l < r; l++) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }

            for (int i = pivot; i < nums.length; i++) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }
    }
}