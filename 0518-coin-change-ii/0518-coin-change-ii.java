class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            prev[i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for (int ind = 1; ind < n; ind++) {

            for (int target = 0; target <= amount; target++) {

                int notTake = prev[target];

                int take = 0;
                if (coins[ind] <= target) {
                    take = curr[target - coins[ind]];
                }

                curr[target] = take + notTake;
            }
            prev = curr;
        }
        return prev[amount];
    }
}