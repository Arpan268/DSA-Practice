class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap();

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        Queue<Character> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

        for(char ch: count.keySet()) {
            heap.add(ch);
        }

        StringBuilder sb = new StringBuilder("");

        while(!heap.isEmpty()) {
            char ch = heap.poll();
            int freq = count.get(ch);
            for(int i = 0; i<freq; i++) {
                sb.append(ch);
            }
        }

        String str = sb.toString();

        return str;
    }
}