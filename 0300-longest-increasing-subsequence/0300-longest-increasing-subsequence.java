class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < n; i++){

            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else {
                int ind = Collections.binarySearch(list, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                list.set(ind, nums[i]);
            }
        }
        return list.size();
    }
}