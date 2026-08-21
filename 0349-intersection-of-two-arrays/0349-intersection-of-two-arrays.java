class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int n: nums1) {
            set1.add(n);
        }

        for(int n: nums2) {
            set2.add(n);
        }

        for(int n: set1) {
            if(set2.contains(n)) {
                list.add(n);
            }
        }

        int intersection[] = new int[list.size()];

        for(int i = 0; i<list.size(); i++) {
            intersection[i] = list.get(i);
        }

        return intersection;
    }
}