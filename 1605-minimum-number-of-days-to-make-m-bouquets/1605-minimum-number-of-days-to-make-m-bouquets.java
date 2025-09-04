class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if (m > bloomDay.length) return -1;
        if (m * k > bloomDay.length) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : bloomDay){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int start = min;
        int end = max;
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

}