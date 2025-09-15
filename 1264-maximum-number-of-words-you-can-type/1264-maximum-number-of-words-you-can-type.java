class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        Set<Character> brokenKeys = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()){
            brokenKeys.add(ch);
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String word : words){  
           for (char ch : word.toCharArray()){
            if (brokenKeys.contains(ch)){
                count++;
                break;
            }
           }
        }
        return words.length - count;    
    }
}