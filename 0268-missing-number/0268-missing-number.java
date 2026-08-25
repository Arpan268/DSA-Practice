class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int missingno = 0;

        for(int n: nums) {
            set.add(n);
        }

        for(int i = 0; i<=nums.length; i++) {
            if(!set.contains(i)) missingno = i;
        }

        return missingno;
    }
}