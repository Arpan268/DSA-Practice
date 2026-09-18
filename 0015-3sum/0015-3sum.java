class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (l < r) {
                int sum = nums[l] + nums[r];
                int required = -1 * nums[i];

                if (sum == required) {
                    List<Integer> indices = Arrays.asList(nums[i], nums[l], nums[r]);
                    list.add(indices);
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                }

                if (sum > required)
                    r--;

                if (sum < required)
                    l++;
            }
        }

        return list;
    }
}