class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q = new ArrayDeque<>();
        int freq[] = new int[26];
        int count = 0, ans = 0;

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        for (int num : freq) {
            if (num > 0) {
                pq.add(num);
            }
        }

        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!pq.isEmpty()) {
                int num = pq.poll();
                num--;
                if(num > 0) {
                    q.add(num);
                }
            }

            count++;
            if (count == n + 1) {
                while (!q.isEmpty()) {
                    pq.add(q.poll());
                }
                count = 0;
            }
            ans++;
        }

        return ans;
    }
}