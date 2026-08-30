class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;
        
        Map<Integer, Integer> map = new TreeMap<>();
        int group = groupSize;

        for(int n: hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n: map.keySet()) {
                int start = n;
                while(map.containsKey(start) && map.get(start) != 0 && group > 0) {
                    if(map.get(start) == 0) return false;
                    map.put(start, map.get(start)-1);
                    group--;
                    start++;
                    if(map.get(n) > 0 && group == 0) {
                        group = groupSize;
                        start = n;
                    }
                }
                if(group != 0 && group != groupSize) return false;
                group = groupSize;
        }

        for(int n: map.values()) {
            if(n > 0) return false;
        }
        return true;
    }
}