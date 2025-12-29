class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        String l = (len1 < len2) ? str1 : str2;

        for (int i = l.length(); i > 0; i--){
            String div = l.substring(0, i);
            if (str1.equals(div.repeat(len1 /(i))) && str2.equals(div.repeat(len2/(i)))){
                return div;
            }
        }
       return ""; 
    }
}