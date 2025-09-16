class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {

        ArrayList<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                int gcd = gcd(top, num);
                if (gcd == 1) {
                    break;
                }
                stack.remove(stack.size() - 1);
                num = (top / gcd) * num;
            }
            stack.add(num);
        }
        return stack;
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}