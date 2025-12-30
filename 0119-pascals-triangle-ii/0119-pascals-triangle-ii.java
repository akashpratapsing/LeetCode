class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++){

            List<Integer> curr = new ArrayList();
            for (int j = 0; j <= i; j++){

                if (j == 0 || j == i){
                    curr.add(1);
                }else {
                    int num1 = prev.get(j);
                    int num2 = prev.get(j - 1);
                    curr.add(num1 + num2);
                }
            }
            prev = curr;
        }
        
        return prev;
        
    }
}