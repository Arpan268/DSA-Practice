class Solution {
    public int findMaxLength(int[] nums) {
        int maxcount = 0, currentcount = 0, point = 0;
        Map <Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) point--;
            else point++;

            if(map.containsKey(point)) {
                currentcount = i-map.get(point);
            }
            else {
                map.put(point, i);
            }

            if(currentcount > maxcount) maxcount = currentcount;
        }

        return maxcount;
    }
}