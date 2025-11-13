class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] curr = new int[n];
        int[] front = new int[n];

        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = i; j >= 0; j--) {
                int u = triangle.get(i).get(j) + front[j];
                int ur = triangle.get(i).get(j) + front[j + 1];
                curr[j] = Math.min(u, ur);
            }
            front = curr.clone();
        }
        return front[0];

    }
}