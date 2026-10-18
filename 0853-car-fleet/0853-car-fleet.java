class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int cars[][] = new int[position.length][2];
        double lasttime = 0, currenttime = 0;
        int fleet = 0;

        for(int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        for(int i = 0; i < cars.length; i++) {
            int pos = cars[i][0];
            int spd = cars[i][1];

            currenttime = (double)(target - pos) / spd;

            if(currenttime > lasttime) {
                fleet++;
                lasttime = currenttime;
            }
        }

        return fleet;
    }
}