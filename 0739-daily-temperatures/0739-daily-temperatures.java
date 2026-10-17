class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int ans[] = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            if(stack.isEmpty()) {
                stack.push(new int[]{temperature, i});
            }
            else if(temperature >= stack.peek()[0]) {
                while(!stack.isEmpty() && temperature > stack.peek()[0]) {
                    int index = stack.peek()[1];
                    stack.pop();
                    ans[index] = i - index;
                }
                stack.push(new int[]{temperature, i});
            }
            else if(temperature < stack.peek()[0]) {
                stack.push(new int[]{temperature, i});
            }
        }

        return ans;
    }
}