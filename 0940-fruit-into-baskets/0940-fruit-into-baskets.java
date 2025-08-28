class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (right < fruits.length){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            if (basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]);
                }
                left++;
            }

            if (basket.size() <= 2){
                maxFruits = Math.max(maxFruits, right - left + 1);
            }
            right++;
        }

        return maxFruits;
    }
}