class Solution {
    public int jump(int[] nums) {
        int steps=0;
        int max=nums[0];
        int maxRechable=Integer.MIN_VALUE;
         if(nums.length<=1){
            return 0;
        }
        for(int i=0; i<nums.length; i++){            
            if(maxRechable<i){
                maxRechable=max;
                steps++;
            }
            max=Math.max(max,i+nums[i]);
            

        }
       return steps; 
    }
}