class KthLargest {

    Queue<Integer> pq;
    int limit;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a, b) -> a - b);
        limit = k;

        for (int n : nums) {
            pq.add(n);

            if (pq.size() > limit) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > limit) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */