class Solution {
    public int smallestAbsent(int[] nums) {

        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            sum += num;
        }

        int avg = (sum / n) + 1;
        int res = (avg > 0) ? avg : 1;

        while (set.contains(res)) {
            res++;
        }
        return res;
    }
}