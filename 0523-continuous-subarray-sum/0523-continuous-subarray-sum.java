class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0, count = 0;

        for(int i = 0; i<nums.length; i++) {  
            pre += nums[i];

            if(map.containsKey(pre%k) && i != map.get(pre%k)+1) count++;
            else if(!map.containsKey(pre%k)) map.put(pre%k, i);
        }

        if(count>0) return true;
        else return false;
    }
}