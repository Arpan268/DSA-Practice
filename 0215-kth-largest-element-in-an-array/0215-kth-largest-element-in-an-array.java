class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);

        for(int n: nums) {
            heap.add(n);
            if(heap.size()>k) heap.poll();
        }

        int ans = heap.peek();
        return ans;
    }
}