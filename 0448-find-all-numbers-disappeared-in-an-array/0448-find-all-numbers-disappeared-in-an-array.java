class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i : nums){
            seen[i] = true;
        }

        for (int i = 1; i <= n; i++){
            if (!seen[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}