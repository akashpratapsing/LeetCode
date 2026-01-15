class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        
        int max = 1;
        int lastInd = 0;

        for (int i = 0; i < n; i++){
            for (int prev = 0; prev < i; prev++){

                if(nums[i] % nums[prev] == 0&& 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if (dp[i] > max){
                max = dp[i];
                lastInd = i;
            }
        }

        List<Integer> lds = new ArrayList<>();
        int curr = lastInd;
        while (curr != -1){
            lds.add(nums[curr]);
            curr = hash[curr];
        }
       
        return lds;
    }
}