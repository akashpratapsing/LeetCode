class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++){
            if (minDiff == arr[i] - arr[i - 1]){
                ans.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
            }
        }
        return ans;
    }
}