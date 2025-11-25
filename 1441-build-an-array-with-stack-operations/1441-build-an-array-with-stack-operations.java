class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> ans = new ArrayList<>();
        int i = 0, j = 1;
        while (i < target.length){
            ans.add("Push");
            if (target[i] == j){
                i++;
            }else {
                ans.add("Pop");
            }
            j++;
        }
        return ans;
        
    }
}