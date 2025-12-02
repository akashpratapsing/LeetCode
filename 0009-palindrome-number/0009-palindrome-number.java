class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int ogNum = x;
        int rev = 0;

        while (ogNum != 0) {
            rev = (rev * 10) + (ogNum % 10);
            ogNum /= 10;
        }

        return (rev == x);

    }
}