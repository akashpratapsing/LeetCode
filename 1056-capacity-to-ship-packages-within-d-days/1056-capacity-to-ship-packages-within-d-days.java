class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int maxCapacity = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : weights){
            maxCapacity += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int start = maxWeight;
        int end = maxCapacity;

        while (start <= end){

            int mid = start + (end - start) / 2;

            if (isPossible(weights, mid) <= days){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int isPossible(int[] nums, int capacity){

        int weight = 0;
        int days = 1;

        for (int i = 0; i < nums.length; i++){
            if (weight + nums[i] <= capacity){
                weight += nums[i];
            }else {
                days += 1;
                weight = nums[i];
            }
        }        
        return days;
    }
}