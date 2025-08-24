class Solution {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;

        for (int i = 0; i < n; i++){
          String st = Arrays.toString(grid[i]);
          map.put(st, map.getOrDefault(st, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++){
            int[] col = new int[n];
            for (int j = 0; j < n; j++){
                col[j] = grid[j][i];
            }

            String st = Arrays.toString(col);
            count += map.getOrDefault(st, 0);
           
        }

        return count;
        
    }
}