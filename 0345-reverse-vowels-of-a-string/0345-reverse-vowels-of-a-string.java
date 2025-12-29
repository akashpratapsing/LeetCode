class Solution {
    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();

        while (left < right) {

            if (!isVowel(arr[left])) {
                left++;
            }

            if (!isVowel(arr[right])) {
                right--;
            }
            if (isVowel(arr[left]) && isVowel(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new StringBuilder().append(arr).toString();
    }

    static boolean isVowel(char c) {
        return (Character.toUpperCase(c) == 'A') ||
                (Character.toUpperCase(c) == 'E') ||
                (Character.toUpperCase(c) == 'I') ||
                (Character.toUpperCase(c) == 'O') ||
                (Character.toUpperCase(c) == 'U');
    }
}