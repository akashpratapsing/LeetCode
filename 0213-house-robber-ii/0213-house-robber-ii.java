class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (i > 0){
                arr1.add(nums[i]);
            }
            if (i < n - 1){
                arr2.add(nums[i]);
            }
        }

        return Math.max(rob(arr1), rob(arr2));
        
    }

    public int rob(ArrayList<Integer> nums){

        if (nums.size() == 1){
            return nums.get(0);
        }

        int prev2 = nums.get(0);
        int prev = Math.max(nums.get(0), nums.get(1));

        for (int i = 2; i < nums.size(); i++){
            int curr = Math.max(nums.get(i) + prev2, prev);
            prev2 = prev;
            prev = curr;
        }

        return prev;

    }
}