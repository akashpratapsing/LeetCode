class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int x = n + m;
        int index2 = x / 2;
        int index1 = index2 - 1;

        int i = 0;
        int j = 0;
        int index = 0;
        int ele2 = -1;
        int ele1 = -1;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (index == index2) {
                    ele2 = nums1[i];
                }
                if (index == index1){
                    ele1 = nums1[i];
                }
                index++;
                i++;
            } else {
                if (index == index2) {
                    ele2 = nums2[j];
                }
                if (index == index1){
                    ele1 = nums2[j];
                }
                index++;
                j++;
            }
        }

        while (i < n) {
            if (index == index2) {
                ele2 = nums1[i];
            }
            if (index == index1){
                ele1 = nums1[i];
            }
            index++;
            i++;
        }
        while (j < m) {
            if (index == index2) {
                ele2 = nums2[j];
            }
            if (index == index1){
                ele1 = nums2[j];
            }
            index++;
            j++;
        }

        if (x % 2 == 0) {
            return (double) (ele1 + ele2) / 2;
        } else {
            return (double) ele2;
        }
    }
}