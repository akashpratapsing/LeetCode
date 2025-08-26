class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == r - l + 1){
                maxLen = Math.max(maxLen, r - l + 1);
            }

            if (map.size() < r - l + 1){
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0){
                    map.remove(c);
                }
                l++;
            }
            r++;
        }

        return maxLen;
    }
}