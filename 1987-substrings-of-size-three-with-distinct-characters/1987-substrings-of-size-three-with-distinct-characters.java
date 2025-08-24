class Solution {
    public int countGoodSubstrings(String s) {

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        while (right < s.length()){

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (right - left + 1 < 3){
                right++;
            }else {
                if (map.size() == 3){
                    ans++;
                }
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0){
                    map.remove(c);
                }
                left++;
                right++;
            }

        }

        return ans;

        
        
    }
}