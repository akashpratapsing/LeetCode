class Solution {
    public boolean checkPoss(String s1, String s2){

        if (s1.length() != s2.length() + 1) return false;

        int i = 0, j = 0;
        while (i < s1.length()){
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }
        return (i == s1.length() && j == s2.length());
    }

    public int longestStrChain(String[] words) {
        
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++){
            for (int prev = 0; prev < i; prev++){

                if(checkPoss(words[i], words[prev]) && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}