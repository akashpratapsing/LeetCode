class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if (m > bloomDay.length) return -1;
        if (m * k > bloomDay.length) return -1;

        System.out.println(m * k);
        System.out.println(bloomDay.length);

        int start = min(bloomDay), end = max(bloomDay);

        while (start <= end){

            int mid = start + (end - start) / 2;

            if (check(bloomDay, mid, m, k)){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    public boolean check(int[] nums, int day, int m, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day) {
                count++;
            } else {
                m -= (count / k);
                count = 0;
            }
        }
        m -= (count / k);
        return (m <= 0) ? true : false;
    }

    public int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public int min(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}