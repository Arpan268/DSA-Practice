class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n: map.keySet()) {
            if(k == 0) {
                if(map.get(n)>1) count++;
            }
            else {
                int diff = n-k;
                if(map.containsKey(diff)) count++;
            }
        }

        return count;
    }
}