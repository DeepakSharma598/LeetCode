class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwise = 0;
        int total = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= Math.min(start, destination) && i < Math.max(start, destination)) {
                clockwise += distance[i];
            }
        }
        return Math.min(clockwise, total - clockwise);
    }
}