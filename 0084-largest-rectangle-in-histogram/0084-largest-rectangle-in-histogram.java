class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxarea = 0;

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            else if (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            }
            else if (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int poppedIndex = stack.pop();
                    int height = heights[poppedIndex];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxarea = Math.max(maxarea, height * width);
                }
                if (stack.isEmpty()) {
                    maxarea = Math.max(maxarea, (i + 1) * heights[i]);
                }
                stack.push(i);
            }
        }

        if (stack.isEmpty()) {
            return maxarea;
        }

        int start = stack.peek() + 1;

        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            int height = heights[poppedIndex];
            int width = stack.isEmpty() ? start : start - stack.peek() - 1;
            maxarea = Math.max(maxarea, height * width);
        }

        return maxarea;
    }
}