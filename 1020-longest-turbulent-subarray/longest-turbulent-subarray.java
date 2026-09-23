class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int curr = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] == nums[i - 1]) {
                curr = 1;
            }
            else if (i == 1 || 
                    (nums[i - 1] > nums[i] && nums[i - 2] < nums[i - 1]) ||
                    (nums[i - 1] < nums[i] && nums[i - 2] > nums[i - 1])) {
                curr++;
            }
            else {
                curr = 2;
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}