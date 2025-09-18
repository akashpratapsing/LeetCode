class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        permutations(0, nums, result, new ArrayList<>(), map);
        return result;
    }

    public void permutations(int index, int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] map){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!map[i]){
                list.add(nums[i]);
                map[i] = true;
                permutations(index + 1, nums, result, list, map);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }

   
}