class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j=0;
        int count=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            count++;
            if(sum>=target){
                min=Math.min(min,count);
            }
            while(sum>=target && j<i){
                sum-=nums[j];
                j++;
                count--;
                if(sum>=target){
                    min=Math.min(min,count);
                }
            }

        }
        if(min==Integer.MAX_VALUE)return 0;
        return min;
        
    }
}