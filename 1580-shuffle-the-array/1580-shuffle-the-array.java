class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] x = new int[n];
        int[] y = new int[n];
        
        for (int i = 0; i < n; i++){
            x[i] = nums[i];
            y[i] = nums[n + i];
        }
        int xi = 0, yi = 0;
        for (int i = 0 ; i < 2 * n; i++){
            if (i % 2 == 0){
                nums[i] = x[xi++];
            }else {
                nums[i] = y[yi++];
            }
        }
        return nums;
    }
}