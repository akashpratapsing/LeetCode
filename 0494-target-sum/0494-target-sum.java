class Solution {
    public int findTargetSumWays(int[] nums, int target) {

		int sum = 0;
		for (int i : nums) sum += i;
		if (sum - target < 0 || (sum - target) % 2 != 0) return 0;

		int k = (sum - target) / 2;
		int[] prev = new int[k + 1];

		// prev[0] = 1;
		
		if (nums[0] == 0) prev[0] = 2;
		else prev[0] = 1;
		if (nums[0] != 0 && nums[0] <= k) prev[nums[0]] = 1;
		for (int i = 1; i < nums.length; i++){
			int[] curr = new int[k + 1];
			curr[0] = 1;
			for (int tar = 0 ; tar <= k; tar++){

				int notTake = prev[tar];
				int take = 0;
				if (nums[i] <= tar){
					take = prev[tar - nums[i]];
				}
				curr[tar] = take + notTake;
			}
			prev = curr;
		}
		return prev[k];
    }
}