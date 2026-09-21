class Solution {
    public int maxTurbulenceSize(int[] nums) {
       int max=Integer.MIN_VALUE;
       for(int i=0; i<=nums.length-1; i++){
        if(i+1<=nums.length-1 &&((i%2==0 &&nums[i]>nums[i+1])||(i%2!=0 &&nums[i]<nums[i+1]))){
            int count=calculate1(i,nums);
            max=Math.max(count,max);
        } 
        else if(i+1<=nums.length-1 &&((i%2==0 &&nums[i]<nums[i+1])||(i%2!=0 &&nums[i]>nums[i+1]))){
            int count=calculate2(i,nums);
            max=Math.max(count,max);
        }
    }
       
       return max==Integer.MIN_VALUE?1:max;
    }
    public int calculate1(int i,int[] nums){
        int count=0;
        while(i+1<=nums.length-1&& ((i%2==0 && (nums[i]>nums[i+1]))||(i%2!=0 && nums[i]<nums[i+1]))){
            count++;
            i++;
        }
        return count+1;
    } 
    public int calculate2(int i,int[] nums){
        int count=0;
        while(i+1<=nums.length-1 && ((i%2==0 && nums[i]<nums[i+1])||(i%2!=0 && nums[i]>nums[i+1]))){
            count++;
            i++;
        }
        return count+1;
    } 
       
}