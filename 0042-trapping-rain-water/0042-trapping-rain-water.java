class Solution {
    public int trap(int[] height) {
        int vol = 0, slowleft = -1, slowright = height.length;

        for (int i = 0; i < height.length; i++) {
            if (slowleft == -1 && height[i] > 0)
                slowleft = i;

            if (height[i] > 0 && i != slowleft && height[i] >= height[slowleft]) {
                int currentblock = height[slowleft];
                int innervol = 0;
                int dist = i - slowleft - 1;
                slowleft++;

                while (slowleft != i) {
                    innervol += height[slowleft];
                    slowleft++;
                }

                vol += currentblock * dist - innervol;
            }
        }

        if (slowleft == -1)
            return 0;

        for (int i = height.length - 1; i >= slowleft; i--) {
            if (slowright == height.length && height[i] > 0)
                slowright = i;

            if (height[i] > 0 && i != slowright && height[i] >= height[slowright]) {
                int currentblock = height[slowright];
                int innervol = 0;
                int dist = slowright - i - 1;
                slowright--;

                while (slowright != i) {
                    innervol += height[slowright];
                    slowright--;
                }

                vol += currentblock * dist - innervol;
            }
        }

        return vol;
    }
}