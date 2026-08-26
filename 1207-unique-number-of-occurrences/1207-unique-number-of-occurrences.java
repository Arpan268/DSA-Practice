class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int n: arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n: map.values()) {
            if(set.contains(n)) return false;
            set.add(n);
        }

        return true;
    }
}