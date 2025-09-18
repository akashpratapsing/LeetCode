class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> list){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            if (i != index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subsets(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}