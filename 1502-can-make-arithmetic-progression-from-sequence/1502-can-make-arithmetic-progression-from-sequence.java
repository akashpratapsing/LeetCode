class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);
        int diff = arr[n - 1] - arr[n - 2];
        for(int i = n - 3; i >= 0; i--){
            if (arr[i + 1] - arr[i] != diff){
                return false;
            }
        }

        return true;
    }
}