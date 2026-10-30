class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < points.length; i++) {
            int dist = (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));

            pq.add(new int[]{dist, i});      
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()) {
            int index = pq.poll()[1];
            ans[i][0] = points[index][0];
            ans[i][1] = points[index][1];
            i++;
        }

        return ans;
    }
}