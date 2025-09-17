class Solution {
    public List<List<Integer>>  subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, 0, result, list);
        return result;
    }

    public void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> list){

        if (index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        subsets(nums, index + 1, result, list);
        list.remove(list.size() - 1);
        subsets(nums, index + 1, result, list);
    }
}