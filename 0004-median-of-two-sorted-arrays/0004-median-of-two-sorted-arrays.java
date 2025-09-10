class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0, end = n1;
        int n = n1 + n2;
        int left = (n + 1) / 2;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int mid2 = left - mid;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid < n1) {
                r1 = nums1[mid];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid - 1 >= 0) {
                l1 = nums1[mid - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}