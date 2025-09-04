class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int div = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int start = 1;
        int end = max;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (getSum(nums, mid) <= threshold) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int getSum(int[] nums, int div) {

        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / (double) div);
        }
        return sum;
    }
}