class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int mid = total / 2;
        int p1 = 0, p2 = 0, prev = 0, curr = 0;

        for (int i = 0; i <= mid; i++) {
            prev = curr;
            if (p1 < m && (p2 >= n || nums1[p1] <= nums2[p2])) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
        }

        return total % 2 == 0 ? (double)(prev + curr) / 2 : (double) curr;
    }
}
