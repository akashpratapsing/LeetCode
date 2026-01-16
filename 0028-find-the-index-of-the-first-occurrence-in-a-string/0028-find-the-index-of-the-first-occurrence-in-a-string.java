class Solution {
    public int strStr(String haystack, String needle) {
        
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length() ; i++){
            if (haystack.substring(i).startsWith(needle)){
                return i;
            }
        }
        return -1;
    }
}