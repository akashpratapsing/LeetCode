class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[ 2 * n];

        int i = 0, j = n;
        int ind = 0;

        while (ind < 2 * n){
            ans[ind] = nums[i++];
            ans[ind + 1] = nums[j++];
            ind +=2;
        }
        return ans;
    }
}