class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] rMin = new int[n + 1];
        int[] rMax = new int[n + 1];
        int[] cMin = new int[n + 1];
        int[] cMax = new int[n + 1];

        Arrays.fill(cMin, n + 1);
        Arrays.fill(rMin, n + 1);

        for (int[] building : buildings){
            int x = building[0];
            int y = building[1];

            rMin[y] = Math.min(rMin[y], x);
            rMax[y] = Math.max(rMax[y], x);
            cMin[x] = Math.min(cMin[x], y);
            cMax[x] = Math.max(cMax[x], y);          
        
        }

        int count = 0;
        for (int[] building : buildings){
            int x = building[0];
            int y = building[1];

            if (x > rMin[y] && x < rMax[y] && y > cMin[x] && y < cMax[x]) {
                count++;
            }
        }
        return count;
    }
}