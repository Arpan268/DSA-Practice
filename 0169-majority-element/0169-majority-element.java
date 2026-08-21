class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majority = 0;

        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        for(int n: map.keySet()) {
            if(map.get(n)>nums.length/2) {
                majority = n;
            }
        }

        return majority;
    }
}