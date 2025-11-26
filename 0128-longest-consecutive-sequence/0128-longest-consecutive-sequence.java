class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        for (int num : set){
            if (!set.contains(num - 1)){

                int currStreak = 1;
                int currNum = num;
                while (set.contains(currNum + 1)){
                    currStreak++;
                    currNum++;
                }
                longest = Math.max(longest, currStreak);
            }
        }
        return longest;
    }
}