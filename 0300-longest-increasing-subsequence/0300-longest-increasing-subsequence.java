class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        int max = 1;
        int lastInd = 0;

        for (int i = 0; i < n; i++){
            for (int prev = 0; prev < i; prev++){

                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if (dp[i] > max){
                max = dp[i];
                lastInd = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        int curr = lastInd;
        while (curr != -1){
            lis.add(nums[curr]);
            curr = hash[curr];
        }
        Collections.reverse(lis);
        System.out.println(lis);
       
        return max;
    }
}