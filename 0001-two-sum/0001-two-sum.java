class Solution {
    public int[] twoSum(int[] nums, int target) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            if (list.contains(val)) {
                return new int[] { i, list.indexOf(val) };
            } else {
                list.add(nums[i]);
            }
        }
        return new int[] {};
    }
}