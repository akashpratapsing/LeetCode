class Solution {
    public String buildKey(String s) {
        int n = s.length();
        if (n == 1) return "one";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
    
    public long countPairs(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String key = buildKey(word);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long count = 0;
        for (int c : map.values()) {
            count += (long) c * (c - 1) / 2;
        }

        return count;
    }
}