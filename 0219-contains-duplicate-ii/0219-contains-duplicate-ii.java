class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int left = 0;
        Set<Integer> seen = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {

            if (right - left > k) {
                seen.remove(nums[left]);
                left++;
            }
            if (seen.contains(nums[right])) {
                return true;
            }
            seen.add(nums[right]);
            
        }
        return false;
    }
}