class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        return count(nums, k) - count(nums, k - 1);
    }

    public int count(int[] nums, int k){

        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            if (map.size() <= k){
                count += right - left + 1;
            }
            right++;
        }
        return count;
    }
}