class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            // Left side values
            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[cut1 - 1];

            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[cut2 - 1];

            // Right side values
            int right1 = (cut1 == n)
                    ? Integer.MAX_VALUE
                    : nums1[cut1];

            int right2 = (cut2 == m)
                    ? Integer.MAX_VALUE
                    : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd total length
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length
                return (
                    Math.max(left1, left2) +
                    Math.min(right1, right2)
                ) / 2.0;
            }

            // Move partition in nums1 to the left
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // Move partition in nums1 to the right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}