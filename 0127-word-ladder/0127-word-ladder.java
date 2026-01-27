class Pair{
    String first;
    int second;

    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        for (String word : wordList){
            set.add(word);
        }        

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        if (set.contains(beginWord)){
            set.remove(beginWord);
        }

        while (!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++){
                for (char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArr = word.toCharArray();
                    replacedCharArr[i] = ch;
                    String replacedWord = new String(replacedCharArr);

                    if (set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps + 1));
                    } 
                }
            }
        }

        return 0;
    }
}