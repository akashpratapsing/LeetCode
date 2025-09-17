class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void combinations(int[] nums, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (index == nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (nums[index] <= target) {
            list.add(nums[index]);
            combinations(nums, target - nums[index], index, result, list);
            list.remove(list.size() - 1);
        }
        combinations(nums, target, index + 1, result, list);
    }
}