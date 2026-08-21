class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int l = nums.length;
        int freq[] = new int[l];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<l; i++) {
            freq[nums[i]-1]++;
        }

        for(int i = 0; i<freq.length;i++) {
            if(freq[i]>1) {
                list.add(i+1);
            }
        }

        return list;
    }
}