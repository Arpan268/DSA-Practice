class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int currentlcs, maxlcs = 1;

        if(nums.length == 0) return 0;

        for(int n: nums) {
            set.add(n);
        }

        for(int n: set) {
            if(!set.contains(n-1)) {
                currentlcs = 0;
                while(set.contains(n)) {
                    currentlcs++;
                    n++;
                }
                if(currentlcs > maxlcs) maxlcs = currentlcs;
            }
        }
        return maxlcs;
    }
}