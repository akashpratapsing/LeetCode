class Solution {
    public String minWindow(String s, String t) {

        int[] hash = new int[256];

        for (char ch  : t.toCharArray()){
            hash[ch]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int sIdx = -1;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()){
            char ch = s.charAt(right);
            if (hash[ch] > 0){
                count++;
            }
            hash[ch]--;

            while (count == t.length()){

                if (right - left + 1 < minLen){
                    minLen = right - left +1;
                    sIdx = left;
                }
                char c = s.charAt(left);
                hash[c]++;
                if (hash[c] > 0){
                    count--;
                }
                left++;
            }
            right++;
        }

        return (sIdx == -1) ? "" : s.substring(sIdx, sIdx + minLen);
    }
}