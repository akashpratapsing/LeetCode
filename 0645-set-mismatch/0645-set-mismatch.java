class Solution {
    public int[] findErrorNums(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() == 2){
                ans[0] = m.getKey();
            }  
        }

        for (int i = 1; i <= nums.length; i++){
            if (!map.containsKey(i)){
                ans[1] = i;
            }
        }

        return ans;
    }
}