class Solution {
    public String mergeAlternately(String word1, String word2) {

       int left = 0, right = 0;
       StringBuilder ans = new StringBuilder();

       while (left < word1.length() && right < word2.length()){
        ans.append(word1.charAt(left++));
        ans.append(word2.charAt(right++));
       }

       if (left < word1.length()){
        ans.append(word1.substring(left));
       }

       if (right < word2.length()){
        ans.append(word2.substring(right));
       }

       return ans.toString();
    }
}