class Solution {
    public List<List<Integer>>  subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int num = 0; num < (1 << n); num++){
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++){
                if ((num & (1 << i)) != 0){
                    list.add(nums[i]);
                }
            }
            result.add(list);
        }
        return result;
    }

  
}