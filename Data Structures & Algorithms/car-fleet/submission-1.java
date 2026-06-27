class Solution {
        /* Thinking
            Input: pos and speed array
            output: No. of car fleet 
            For each car we will determine the time to reach the target    

            time = (target-pos)/speed
        */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort by position descending — closest to target first
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0;

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > prevTime) {   // can't catch the car ahead → new fleet
                fleets++;
                prevTime = time;
            }
            // if time <= prevTime, it catches up → same fleet, don't update prevTime
        }
        return fleets;
    }
}
