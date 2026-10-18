class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int cars[][] = new int[position.length][2];
        Deque<Double> stack = new ArrayDeque<>();
        double time = 0;

        for(int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        for(int i = 0; i < cars.length; i++) {
            int pos = cars[i][0];
            int spd = cars[i][1];

            time = (double)(target - pos) / spd;

            if(stack.isEmpty()) {
                stack.push(time);
            }
            else if(!stack.isEmpty() && time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}