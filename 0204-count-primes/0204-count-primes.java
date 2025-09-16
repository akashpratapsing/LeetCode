class Solution {
    public int countPrimes(int n) {
        if (n == 0) return 0;
        int[] arr = getSieve(n);
        return arr[n - 1];
        
    }
    public int[] getSieve(int n){
        int[] arr = new int[n + 1];

        for (int i = 2; i < arr.length; i++){
            arr[i] = 1;
        }

        for (int i = 2; i * i < arr.length; i++){
            if (arr[i] == 1){
                for (int j = i * i; j < arr.length; j += i){
                    arr[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            count = count + arr[i];
            arr[i] = count;
        }
        return arr;
    }
}