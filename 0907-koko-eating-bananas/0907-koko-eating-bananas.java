class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = max(piles);
        int ans = Integer.MAX_VALUE;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int speed = getSpeed(piles, mid);

            if (speed <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int getSpeed(int[] nums, int h) {

        int ans = 0;
        for (int num : nums) {
            ans += Math.ceil((double) num / (double) h);
        }
        return ans;
    }

    public int max(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}