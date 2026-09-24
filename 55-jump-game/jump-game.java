class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable=Integer.MIN_VALUE;
        int n=0;
        if(nums.length==1){
            return true;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0 && maxReachable<=i){
                return false;
            }
            maxReachable=Math.max(maxReachable,nums[i]+i);
            if(maxReachable>=nums.length-1){
                return true;
            }
        }
        return false;

    }
}