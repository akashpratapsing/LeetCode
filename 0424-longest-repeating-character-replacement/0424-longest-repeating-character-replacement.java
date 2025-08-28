class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int maxF = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxF = Math.max(maxF, map.get(ch));

            while ((right - left + 1) - maxF > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }

            if ((right - left + 1) - maxF <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }

        return maxLen;
    }
}