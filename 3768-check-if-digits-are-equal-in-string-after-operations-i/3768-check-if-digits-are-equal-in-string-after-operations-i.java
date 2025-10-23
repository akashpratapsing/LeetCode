class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int size = arr.length;

        while(size-- > 2){
            for (int i = 0; i < size; i++){
                arr[i] = (char)((arr[i] - '0' + arr[i + 1] - '0') % 10 + '0');
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[0] == arr[1];
    }
}