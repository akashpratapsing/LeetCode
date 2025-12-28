class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long c1 = (1L * need1 * cost1) + (1L * need2 * cost2);
        long c2 = 1L * costBoth * Math.max(need1, need2);
        
        long k = Math.min(need1, need2);
        long c3 = (1L * k * costBoth);

        need1 -= k;
        need2 -= k;

        c3 +=  (1L * need1 * cost1) + (1L * need2 * cost2);
        long total = Math.min(c1, Math.min(c2, c3));

        return total;
    }
}