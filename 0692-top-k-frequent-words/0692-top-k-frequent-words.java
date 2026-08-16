class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> list = new ArrayList<>();

        Map<String, Integer> count = new HashMap<>();

        for(String str: words) {
            count.put(str, count.getOrDefault(str, 0) + 1);
        }

        Queue<String> heap = new PriorityQueue<>((a,b) -> {
            if(count.get(a).equals(count.get(b))) {
                return b.compareTo(a);
            }
            return count.get(a)-count.get(b);
            });

        for(String str: count.keySet()) {
            heap.add(str);
            if(heap.size()>k) heap.poll();
        }

        while(!heap.isEmpty()) {
            String str = heap.poll();
            list.add(0, str);
        }

        return list;
    }
}